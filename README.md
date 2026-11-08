# Assignment 3. Maze Escape

Student ID: 252156
Name: Urazbek Bek
Group: SE-2512
Maze size (rows x columns): 8 x 8

## Program output

The 13 lines my program prints on my data (`java -cp out Main`):

    Broken: 63
    Kept: 49
    Last broken wall: 93
    MST cost: 20888
    Heaviest broken wall: 748
    Path length: 16
    DFS visited: 49
    Dead ends: 19
    Zones: 8
    Largest zone: 12
    Is DAG: 0
    Flow stages: 5
    Fastest route cost: 22

 

## Questions

Mission 0. What do find and union do, and what makes them fast in your code?

`find(x)` walks up the parent pointers to the root of the set of x and then points every cell on the way straight at the root (path compression). `union(a, b)` finds both roots; if they differ, it hangs the smaller tree under the larger one (union by size) and returns true, otherwise it returns false. These two tricks keep the trees almost flat, so one operation costs almost O(1). `find` is a loop, not recursion, so a long chain cannot overflow the stack.

Mission 1. Why is Broken always R*C - 1, and Kept always (R-1)*(C-1)?

At the start there are R*C sets, one per cell. A wall is broken only when `union` joins two different sets, so every broken wall reduces the number of sets by exactly one. The grid is connected, so at the end there is one set, and that needs exactly R*C - 1 successful unions. There are 2RC - R - C inner walls, so Kept = 2RC - R - C - (RC - 1) = (R-1)*(C-1). For my 8 x 8 maze: Broken = 63, Kept = 49.

Mission 2. My MST cost from Kruskal and from Prim, and why they are equal:

Both give 20888. All wall costs are different, so the cheapest maze is unique. Both algorithms use the same rule: the cheapest wall that joins two different parts of the maze is always safe to break. Kruskal applies it with the sets of the DSU, Prim applies it to one growing part, so they find the same tree and the same total cost.

Mission 3. Why is there exactly one path between two cells? How did you avoid a stack overflow on a huge maze?

The maze is a tree: it is connected, because all cells end in one set, and it has no cycle, because a wall is broken only if its two cells are in different sets. Two different paths between two cells would contain a cycle, so there is exactly one path. My DFS uses my own array `stack` instead of recursion, so the depth is limited by memory and not by the call stack. I tested a 1000 x 1000 maze with `-Xss256k` and it worked.

Mission 4. Why does the second pass of Kosaraju go on the reversed graph? Why do the slides have no cycle exactly when Zones equals the number of cells?

The cell that finishes last in the first pass lies in a zone that has no slides coming in from other zones. On the reversed slides this zone has no way out, so DFS from that cell collects exactly this one zone. On the normal slides DFS would run into the next zones and mix them. A cycle puts all its cells into one zone with at least two cells, so there would be fewer zones than cells. If Zones equals the number of cells, every zone has one cell, and since no slide goes from a cell to itself, there is no cycle.

Mission 5. Why is it enough to go through the zones in the order of their numbers? What does this pass cost?

The numbers are a topological order: every slide between two zones goes from a smaller number to a larger one. When we reach zone X, all zones with a slide into X are already done, so the stages and the cost of X are final, and we only relax the slides that leave X. The zone graph has no cycle, so no priority queue is needed. The cost is O(n + S) time and O(n + S) space: a counting sort of the slides by zone and one pass over zones and slides.

 
## Timing (Mission 7)

Milliseconds, 5 runs each (average), from `java -cp out Bench`.

| maze | Kruskal | Prim |
|---|---|---|
| 100 x 100 | 11 | 11 |
| 300 x 300 | 57 | 67 |
| 1000 x 1000 | 327 | 1252 |

Both grow a little faster than linearly, as O(m log m) predicts: from 300 x 300 to 1000 x 1000 there are 11 times more cells, and Kruskal takes about 6 times longer, Prim about 19 times longer. On the largest maze Prim is about 4 times slower than Kruskal: its PriorityQueue holds boxed Long objects and jumps around in memory, while Kruskal sorts one array of primitive longs and then does almost constant-time DSU operations.

## Complexity

n is the number of cells, m the number of walls (or slides).

| algorithm | time | space | assumptions |
|---|---|---|---|
| DSU find and union | O(alpha(n)) amortized per operation, almost O(1) | O(n) | union by size and path compression together; one `find` alone can be O(log n) |
| Kruskal | O(m log m) = O(m log n) | O(n + m) | sorting of m walls dominates; the m DSU operations cost O(m alpha(n)) |
| Prim | O(m log m) = O(m log n) | O(n + m) | binary-heap PriorityQueue with lazy deletion (up to 2m entries); graph in arrays |
| DFS | O(n + m) | O(n) | own stack, no recursion; in the maze m = n - 1 because it is a tree |
| Kosaraju | O(n + m) | O(n + m) | two DFS passes, one on the slides and one on the reversed slides; m = number of slides |
| Route in the zone graph | O(n + m) | O(n + m) | zones in topological order, one pass, no priority queue; counting sort of slides by zone |
