# DAA — Assignment 2 report — Who Goes Next

Name: Urazbek Bek (SE-2512)
Barcode: 252156

## 1. Correctness

Output of `java Main 252156` (all lines OK):

```
barcode,252156
room,checksum,critical_served,critical_wait
fifo,333383335000,996,4962833
array,662867625159,2005,1245
list,662867625159,2005,1245
heap,662867625159,2005,1245

OK   FifoQueueRoom matches the fixed no-triage checksum for any barcode.
OK   SortedListRoom calls the patients in exactly the same order as the given ArrayRoom.
OK   HeapRoom calls the patients in exactly the same order as the given ArrayRoom.
OK   FifoQueueRoom throws IllegalStateException on an empty room.
OK   SortedListRoom throws IllegalStateException on an empty room.
OK   HeapRoom throws IllegalStateException on an empty room.
OK   CallLog records every call and recent(3) is non-destructive and most-recent-first.

never called by the end of the shift, by severity:
  no triage (fifo)   s5 1009     s4 1456     s3 2522     s2 2443     s1 2570  
  with triage        s5 0        s4 0        s3 45       s2 4949     s1 5006
```

## 2. Complexity

**SortedListRoom.add**
- Worst case, one call: Θ(n). The new patient may belong at the very end, so the cursor walks the whole list (n nodes).
- Amortised: also Θ(n) per call. There is no resize and no rare expensive step to spread out; a typical call still walks about half the list, so the cost does not shrink on average.
- Why they are the same: the cost comes from walking the list on every call, not from an occasional event.

**HeapRoom.add**
- Worst case, one call: Θ(n). The one call that finds the array full allocates an array of size 2n and copies n elements, exactly like `ArrayRoom.add`.
- Amortised: O(log n) per call. Resizes happen only when the size reaches 4, 8, 16, ..., so total copying over n calls is O(n), which is O(1) per call; the sift-up adds O(log n) (the height of the heap) to every call.
- Why they differ: the resize is rare (the array doubles), so its cost is spread over many cheap calls, while the Θ(n) worst case is real but happens only once per doubling.

## 3. Benchmark

Output of `java Bench 252156` on my machine (best of 3, one warm-up):

```
A - one whole shift, milliseconds
       n      array       list       heap
    1000       1.28       0.98       0.95
    5000       4.03       7.21       0.66
   20000      77.48     120.44       1.56
  from n=5000 to n=20000 (4x the patients):   array x19.2   list x16.7   heap x2.4

B - the two operations on their own, in a room already holding 19000 patients
    room      1000 adds, ms     1000 calls, ms
   array              0.012             33.296
    list             46.966              0.067
    heap              0.029              0.164
```

**Table A.** The room holds on the order of n patients, so array (`next` scans everyone) and list (`add` walks the list) cost Θ(n) per operation and Θ(n²) per shift: 4x the patients should cost about 16x. Measured: array x19.2 and list x16.7, which match (array is a little above 16x because a bigger array no longer fits in the CPU cache). The heap does Θ(n log n) work, so the prediction is about 4x·(log 20000 / log 5000) ≈ 4.6x, but I measured x2.4. This is lower than predicted because the heap's times are only about 1 ms, where JIT compilation and fixed overheads dominate (n=5000 was even faster than n=1000). The important point is the shape: the heap grows far slower than array and list, and at n=20000 it is about 50x faster than the array and 75x faster than the list.

**Table B.** Array: the expensive operation is the call (33.3 ms per 1000), because `next` scans all patients; `add` is almost free (0.012 ms), it only appends. List: the expensive operation is `add` (47.0 ms), because it walks to the right place; `next` only unlinks the head (0.067 ms). Heap: both are cheap (0.029 and 0.164 ms), matching O(log n). The heap's call is slower than its add because siftDown goes down the full height with two comparisons per level, while siftUp usually stops after a step or two.

Numbers depend on my machine, JIT warm-up and background load, so only the growth shape is comparable, not the exact milliseconds.

## 4. Triage effect

From the "never called" table (barcode 252156): with no triage 1009 severity-5 patients and 1456 severity-4 patients were never called; with triage both are 0, and severity 3 drops from 2522 to 45. Triage also cut the average wait of critical patients from about 4983 minutes (4962833 / 996 served) to about 0.6 minutes (1245 / 2005 served).

The cost falls on the least severe: never-called severity 2 rises from 2443 to 4949 and severity 1 from 2570 to 5006, roughly doubling, because the doctor calls only 10,000 of 20,000 patients and the severe ones take those slots first.
