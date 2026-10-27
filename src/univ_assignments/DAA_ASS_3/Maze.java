package univ_assignments.DAA_ASS_3;

import java.util.*;

public class Maze {

    /** Mission 1. Қабырғаларды файл ретімен алу; ұяшықтары әр түрлі жиында болса сындыру. */
    public static int[] breakWalls(Input.Walls w) {
        DisjointSet dsu = new DisjointSet(w.cells());
        int[] broken = new int[w.cells() - 1];   // ағаш ешқашан cells-1 қырдан көп болмайды
        int count = 0;
        for (int k = 0; k < w.count(); k++) {
            if (dsu.union(w.a()[k], w.b()[k])) broken[count++] = k;
            // әйтпесе ұяшықтар бұрыннан жалғасқан, қабырға қалады (сындырсақ цикл шығады)
        }
        return Arrays.copyOf(broken, count);
    }

    /** Mission 2. Kruskal: ең арзанынан ең қымбатына қарай. */
    public static int[] cheapestMaze(Input.Walls w) {
        int m = w.count();
        // (cost, index) жұбын бір long-ға тығып сұрыптаймыз (boxing жоқ, жылдам)
        long[] keys = new long[m];
        for (int k = 0; k < m; k++) keys[k] = ((long) w.cost()[k] << 32) | k;
        Arrays.sort(keys);

        DisjointSet dsu = new DisjointSet(w.cells());
        int[] broken = new int[w.cells() - 1];
        int count = 0;
        for (long key : keys) {
            int k = (int) (key & 0xFFFFFFFFL);
            if (dsu.union(w.a()[k], w.b()[k])) {
                broken[count++] = k;
                if (count == w.cells() - 1) break;   // ағаш дайын
            }
        }
        return Arrays.copyOf(broken, count);
    }

    /** Mission 2. Prim + PriorityQueue. Ең арзан лабиринттің жалпы құнын қайтарады. */
    public static long primCost(Input.Walls w) {
        int n = w.cells(), m = w.count();

        // көрші тізімдері массивте: u ұяшығының қабырғалары start[u] .. start[u+1]-1
        int[] start = new int[n + 1];
        for (int k = 0; k < m; k++) { start[w.a()[k] + 1]++; start[w.b()[k] + 1]++; }
        for (int i = 0; i < n; i++) start[i + 1] += start[i];
        int[] to = new int[2 * m], cost = new int[2 * m], fill = Arrays.copyOf(start, n);
        for (int k = 0; k < m; k++) {
            int a = w.a()[k], b = w.b()[k];
            to[fill[a]] = b; cost[fill[a]++] = w.cost()[k];
            to[fill[b]] = a; cost[fill[b]++] = w.cost()[k];
        }

        // кезекте ағаштан шығатын қабырғалар, ең арзаны бірінші: (cost, cell) long-та
        PriorityQueue<Long> pq = new PriorityQueue<>();
        boolean[] inTree = new boolean[n];
        long total = 0;
        int taken = 1;
        inTree[0] = true;
        for (int e = start[0]; e < start[1]; e++) pq.add(((long) cost[e] << 32) | to[e]);

        while (!pq.isEmpty() && taken < n) {
            long top = pq.poll();
            int v = (int) (top & 0xFFFFFFFFL);
            if (inTree[v]) continue;                 // бұл қабырға енді ағаштың ішіне апарады: өткізіп жіберу
            inTree[v] = true;
            taken++;
            total += top >>> 32;                     // ағаштан шығатын ең арзан қабырғаны сындыру
            for (int e = start[v]; e < start[v + 1]; e++) {
                if (!inTree[to[e]]) pq.add(((long) cost[e] << 32) | to[e]);
            }
        }
        return total;
    }
}
