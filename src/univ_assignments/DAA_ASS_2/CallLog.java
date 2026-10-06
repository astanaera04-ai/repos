package univ_assignments.DAA_ASS_2;

import java.util.ArrayList;
import java.util.List;

/**
 * TASK 4. You write this one. About 20 lines.
 *
 * A stack backed by your own growing array -- double it when full, same
 * idea as ArrayRoom and HeapRoom, one more time.
 *
 * WHO CALLS IT
 *   You never call push yourself. Shift calls it once every time any room's
 *   next() is invoked during the graded run, so by the end of a shift
 *   CallLog holds a complete history of every call, in order, on top of
 *   whichever room is under test.
 *
 * THE PART THAT DECIDES YOUR MARK
 *   recent(n) must be READ-ONLY: it returns the n most recently called
 *   patients, most recent first, WITHOUT changing size() and WITHOUT
 *   changing what a second call to recent(n) returns. Do not implement it
 *   by popping -- that's the single most common way to fail this task, and
 *   Main's check is specifically built to catch it.
 */
public class CallLog {

    public static final class Entry {
        public final Patient patient;
        public final int minute;
        public Entry(Patient patient, int minute) { this.patient = patient; this.minute = minute; }
    }

    private Entry[] a = new Entry[4];
    private int size;

    public void push(Entry e) {
        if (size == a.length) {
            Entry[] bigger = new Entry[a.length * 2];
            System.arraycopy(a, 0, bigger, 0, size);
            a = bigger;
        }
        a[size] = e;
        size++;
    }

    public Entry pop() {
        if (size == 0) return null;
        size--;
        Entry top = a[size];
        a[size] = null;
        return top;
    }

    public Entry peek() {
        if (size == 0) return null;
        return a[size - 1];
    }

    public int size()        { return size; }
    public boolean isEmpty() { return size == 0; }

    /** The n most recently called patients, most recent first. Does not change size(). */
    public List<Entry> recent(int n) {
        n = Math.max(0, Math.min(n, size));
        List<Entry> out = new ArrayList<>(n);
        for (int i = 0; i < n; i++) out.add(a[size - 1 - i]);   // read only, never pop
        return out;
    }
}
