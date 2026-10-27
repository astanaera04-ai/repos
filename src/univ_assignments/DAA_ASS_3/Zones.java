package univ_assignments.DAA_ASS_3;

import java.util.Arrays;

public class Zones {

    /** Mission 4. Kosaraju. zoneOf[cell] = зона нөмірі (0 .. zones-1), нөмірлер топологиялық ретпен. */
    public static int[] kosaraju(Input.Slides s) {
        int n = s.n();
        int[][] out = Graphs.slidesFrom(s);
        int[][] in = Graphs.slidesInto(s);

        // 1-өту: slides бойынша DFS; ұяшық АЯҚТАЛҒАНДА order-ге жазылады
        boolean[] seen = new boolean[n];
        int[] order = new int[n];
        int finished = 0;
        int[] stack = new int[n];
        int[] next = new int[n];                 // әр ұяшық үшін out[cell] ішіндегі келесі slide
        for (int root = 0; root < n; root++) {
            if (seen[root]) continue;
            int top = 0;
            stack[0] = root;
            seen[root] = true;
            while (top >= 0) {
                int u = stack[top];
                if (next[u] < out[u].length) {
                    int v = s.to()[out[u][next[u]++]];
                    if (!seen[v]) { seen[v] = true; stack[++top] = v; }
                } else {
                    order[finished++] = u;       // u аяқталды
                    top--;
                }
            }
        }

        // 2-өту: соңғы аяқталғаннан бастап; ТЕРІС slides бойынша DFS бір зонаны толық жинайды
        int[] zoneOf = new int[n];
        Arrays.fill(zoneOf, -1);
        int zones = 0;
        for (int i = n - 1; i >= 0; i--) {
            int root = order[i];
            if (zoneOf[root] != -1) continue;
            int top = 0;
            stack[0] = root;
            zoneOf[root] = zones;
            while (top >= 0) {
                int u = stack[top--];
                for (int slide : in[u]) {
                    int v = s.from()[slide];     // u-ға slide жүргізетін ұяшық
                    if (zoneOf[v] == -1) { zoneOf[v] = zones; stack[++top] = v; }
                }
            }
            zones++;                              // зоналар 2-өту тапқан ретпен нөмірленеді
        }
        return zoneOf;
    }

    /**
     * Mission 5. Зоналар графы: X-тен Y-ке қыр = ең арзан slide, зона ішінде жүру тегін.
     * Зоналарды нөмір ретімен бір рет өтеміз (priority queue жоқ).
     * [0] flow stages: ең ұзын зона тізбегіндегі зона саны;
     * [1] 0-ұяшық зонасынан соңғы ұяшық зонасына ең арзан жолдың құны.
     */
    public static long[] routes(Input.Slides s, int[] zoneOf, int zoneCount) {
        int m = s.count();

        // slides-ті басталатын зонасы бойынша топтау (counting sort)
        int[] startAt = new int[zoneCount + 1];
        for (int i = 0; i < m; i++) startAt[zoneOf[s.from()[i]] + 1]++;
        for (int z = 0; z < zoneCount; z++) startAt[z + 1] += startAt[z];
        int[] byZone = new int[m];
        int[] fill = Arrays.copyOf(startAt, zoneCount);
        for (int i = 0; i < m; i++) byZone[fill[zoneOf[s.from()[i]]]++] = i;

        final long INF = Long.MAX_VALUE / 4;
        long[] stages = new long[zoneCount];     // stages[z] = z-те аяқталатын тізбектегі ең көп зона
        long[] cost = new long[zoneCount];       // cost[z] = бастапқы зонадан z-ке ең арзан жол
        Arrays.fill(stages, 1);
        Arrays.fill(cost, INF);
        int startZone = zoneOf[0], exitZone = zoneOf[s.n() - 1];
        cost[startZone] = 0;

        // зона нөмірлері топологиялық реттен тұрады: X-ке жеткенде оған slide жүргізетін
        // барлық зоналардың stages пен cost мәні дайын. Сондықтан бір өту жеткілікті.
        long best = 1;
        for (int x = 0; x < zoneCount; x++) {
            best = Math.max(best, stages[x]);
            for (int p = startAt[x]; p < startAt[x + 1]; p++) {
                int slide = byZone[p];
                int y = zoneOf[s.to()[slide]];
                if (y == x) continue;            // зона ішіндегі slide: ішінде жүру тегін
                stages[y] = Math.max(stages[y], stages[x] + 1);
                if (cost[x] < INF) cost[y] = Math.min(cost[y], cost[x] + s.time()[slide]);
            }
        }
        return new long[]{best, cost[exitZone]};
    }
}