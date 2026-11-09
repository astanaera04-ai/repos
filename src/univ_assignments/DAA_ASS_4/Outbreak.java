package univ_assignments.DAA_ASS_4;
import java.util.*;

public class Outbreak {

    // Mission 5a: whom to test (DP on a tree)
    public static boolean[] cheapestTests(int n, int[][] nb, int[] cost) {
        int[] parent = new int[n];
        int[] order = bfsOrder(n, nb, parent);               // the root first, every person after his parent

        // for every person v (looking at v and everything below him):
        //   in[v]  = the smallest cost of his subtree when v IS tested
        //   out[v] = the smallest cost of his subtree when v is NOT tested
        long[] in = new long[n], out = new long[n];
        for (int v = 0; v < n; v++) in[v] = cost[v];         // start: tested = his own price, not tested = 0 (children are added below)
        for (int idx = order.length - 1; idx >= 1; idx--) {  // from the last person to the first: all children are done before the parent
            int v = order[idx], p = parent[v];
            in[p] += Math.min(in[v], out[v]);                // p is tested: the link p-v is covered, v may be tested or not, take the cheaper
            out[p] += in[v];                                 // p is not tested: the link p-v needs v tested
        }

        // rebuild: who is tested. Go from the root down and use the same rule.
        boolean[] tested = new boolean[n];
        tested[order[0]] = in[order[0]] <= out[order[0]];
        for (int idx = 1; idx < order.length; idx++) {
            int v = order[idx], p = parent[v];
            tested[v] = !tested[p] || in[v] <= out[v];       // parent not tested: v must be tested; otherwise take the cheaper state
        }
        return tested;
    }

    // the order of a BFS from person 0 (every person comes after his parent). parent[0] = -1
    private static int[] bfsOrder(int n, int[][] nb, int[] parent) {
        int[] order = new int[n];
        boolean[] seen = new boolean[n];
        int head = 0, tail = 0;
        Arrays.fill(parent, -1);
        order[tail++] = 0;
        seen[0] = true;
        while (head < tail) {
            int v = order[head++];
            for (int c : nb[v]) {
                if (seen[c]) continue;                       // this is the parent: the link has no direction, so remember where we came from
                seen[c] = true;
                parent[c] = v;
                order[tail++] = c;
            }
        }
        return Arrays.copyOf(order, tail);
    }

    // Mission 5b: the longest chain (the longest path in the tree, in links)
    public static int longestChain(int n, int[][] nb) {
        int[] parent = new int[n];
        int[] order = bfsOrder(n, nb, parent);
        int[] first = new int[n], second = new int[n];       // the two longest ways down from every person (in links)
        int best = 0;
        for (int idx = order.length - 1; idx >= 0; idx--) {  // children before parents
            int v = order[idx];
            best = Math.max(best, first[v] + second[v]);     // the longest chain whose highest person is v
            int p = parent[v];
            if (p < 0) continue;
            int way = first[v] + 1;                          // the way down from p through v
            if (way > first[p]) { second[p] = first[p]; first[p] = way; }
            else if (way > second[p]) second[p] = way;
        }
        return best;
    }
}
