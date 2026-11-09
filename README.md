# Assignment 4. Patient Zero

Student ID: 252156
Name: Urazbek Bek
Group: SE-2512

## Program output

The 9 lines my program prints on my data (`java -cp out Main`):

    Mutations: 77
    Shared core: 1042
    Marker hits: 4
    First hit: 5861
    Border length: 3
    Shared words: 482
    Tests needed: 36
    Cheapest testing: 177
    Longest chain: 27

My outbreak report (a screenshot of `output/outbreak.html`):

![outbreak](output/outbreak.png)

## Questions

Mission 1. What does the cell d[i][j] of your table mean, and how is it computed from other cells?

d[i][j] is the smallest number of changes (replace, insert, delete) that turn the first i letters of A into the first j letters of B. The first row is d[0][j] = j (insert j letters) and the first column is d[i][0] = i (delete i letters). For the other cells I take the smallest of three things: d[i-1][j-1] plus 0 if the last letters are equal and plus 1 if not (replace), d[i-1][j] + 1 (delete the last letter of A), and d[i][j-1] + 1 (insert the last letter of B). The answer is the corner d[n][m]; for my strains it is 77.

Mission 2. How is the longest common subsequence different from the longest common substring? My Shared core is bigger than the number of letters that are the same at the same place: why?

A common substring must be one piece of letters that are next to each other in both strains, a common subsequence may skip letters but keeps the order. The table is the same, but when the letters are equal I take d[i-1][j-1] + 1, and otherwise the bigger of the top and the left cell (a substring would reset to 0). In my data only 315 letters are the same at the same place, but Shared core is 1042: after one insertion or deletion all the letters behind it move by one place, so they are no longer equal "at the same place", but they still stay in the same order, and the subsequence follows them.

Mission 3. What does the prefix function tell you, and why does the pointer in the text never go back in KMP? What is the Border length of my marker and what does it mean?

pi[i] is the length of the longest proper prefix of marker[0..i] that is also its suffix, so it says how much of the match is still useful after a mismatch. In KMP the number k of matched letters is cut to pi[k-1] on a mismatch: the letters of the text that we already read are known to be equal to the beginning of the marker, so we only move the marker and never read the text again; the text pointer i only goes forward, and the whole search is O(n + m). My marker is TAGGCATAG, its Border length is 3: the prefix TAG is also the suffix TAG. It means two occurrences of my marker can overlap by 3 letters, so after a full match KMP continues with k = 3 and not with 0.

Mission 4. Why must you compare the letters after the hashes are equal? What happens to the cost of Rabin-Karp if many windows have the same hash?

Different words can have the same hash (a collision), so equal hashes only mean "probably equal"; without the comparison I would count false alarms and the answer would depend on MOD. The comparison costs k = 12 steps, but it is done only when the hash is found in B, so on average the cost of the whole search is O(n + m). If many windows have the same hash (for example a tiny MOD), every window is compared with many windows of B and the time goes towards O(n * m * k), as slow as the naive search. In the lab with the hash size 101 there were 593 false alarms and my answer stayed the same because of the comparison.

Mission 5. What are the two states of a person in your DP, and how do you get the answer for a person from its children? Why does a greedy "test the person with most links first" not always give the cheapest answer?

For every person v I keep in[v], the smallest cost of v and everything below him when v is tested, and out[v], the same when v is not tested. in[v] = cost[v] + the sum over the children c of min(in[c], out[c]) (the link to every child is already covered, so a child may be tested or not); out[v] = the sum over the children c of in[c] (v is not tested, so every child must be tested). The answer is min(in[0], out[0]) at the root, and to see who is tested I walk from the root down: a child of a not tested person is tested, otherwise I take the cheaper state. Greedy fails when the person with most links is expensive: in a star with the centre costing 10 and three leaves costing 1, greedy tests the centre for 10, but testing the three leaves costs only 3.

## AI use

Tool: Claude (Anthropic). I used it to write a first version of the code for Missions 1 to 5, to draft the answers in this README, and to explain the algorithms (edit distance, LCS, KMP, Rabin-Karp, DP on a tree). The code was checked with `java tools/Check.java`, with the lab console, and against an independent reference solution on thousands of random small cases and on data of several other student IDs. I did not copy code from books or websites.

## Timing (Mission 7)

Milliseconds, average of 3 runs, from `java -cp out Bench`.

| test | size | time |
|---|---|---|
| naive search | 20 000 / 40 000 / 80 000 | 42.4 / 32.3 / 61.5 |
| KMP | 20 000 / 40 000 / 80 000 | 1.5 / 1.5 / 0.5 |
| edit distance | 500 / 1000 / 2000 / 4000 | 5.6 / 10.2 / 25.3 / 107.7 |

The naive search does about n * m letter comparisons for this text, so when the text doubles its time doubles (32 ms to 62 ms from 40 000 to 80 000; the 20 000 value is slow because the JVM is still warming up), while KMP reads every letter once, so it stays at about 1 ms and is far faster. The edit distance fills n * m cells, so when the size doubles the time grows about 4 times: 25 ms to 108 ms from 2000 to 4000 (the first sizes are too small to show it clearly because of the JVM warm-up and the noise).

## Complexity

n is the length of the text (or of a strain), m the length of the pattern, k the length of the window, v the number of people. For the two strains the lengths are n and m.

| algorithm | time | space | assumptions |
|---|---|---|---|
| Edit distance | O(n * m) | O(n * m) | the whole table (n+1) x (m+1) is kept; two rows would give O(m) space but then the route back cannot be rebuilt |
| LCS | O(n * m) | O(n * m) | the same table, one comparison and one max per cell |
| Prefix function and KMP | O(n + m) | O(n + m) | the prefix function is O(m) (k only grows by 1 per step and falls at most as much), the search O(n); the space is pi (m) and the array of hits (up to n) |
| Rabin-Karp (shared words) | expected O(n + m) for k = 12 (every window is O(1), a comparison costs k only when the hash is found); worst case O(n * m * k) | O(m) | a big modulus so that the hashes are spread; the hashes of the windows of B are in a HashMap; if many windows have the same hash the time goes up to the worst case |
| Tree DP | O(v) | O(v) | BFS order from person 0 and one pass backwards (no recursion), then one pass down to rebuild who is tested; the tree has v - 1 links |
| Longest chain | O(v) | O(v) | the same BFS order, the two longest ways down for every person |
