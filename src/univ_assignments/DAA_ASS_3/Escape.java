package univ_assignments.DAA_ASS_3;

public class Escape {

    public record Result(int[] path, int visited, int deadEnds) {}

    public static Result escape(Input.Walls w, int[] broken) {
        int rows = w.rows(), cols = w.cols(), n = w.cells();
        int exit = n - 1;
        int[][] open = Graphs.open(w, broken);

        // dead end: дәл бір ашық есігі бар ұяшық
        int deadEnds = 0;
        for (int[] doors : open) if (doors.length == 1) deadEnds++;

        // рекурсиясыз DFS: өз стегіміз. stack[0..top] әрқашан старттан қазіргі ұяшыққа дейінгі жол,
        // сондықтан шығуға жеткенде стек өзі жол болады.
        boolean[] seen = new boolean[n];
        int[] stack = new int[n];
        int[] nextDir = new int[n];   // әр ұяшық үшін келесі бағыт (0 жоғары, 1 оң, 2 төмен, 3 сол)
        int top = 0;
        stack[0] = 0;
        seen[0] = true;
        int visited = 1;

        while (top >= 0 && stack[top] != exit) {
            int cell = stack[top];
            boolean moved = false;
            while (nextDir[cell] < 4) {
                int next = neighbour(cell, nextDir[cell]++, rows, cols);
                if (next < 0 || seen[next] || !contains(open[cell], next)) continue;   // қабырға, шек немесе белгіленген
                seen[next] = true;       // ұяшыққа кірген сәтте белгілейміз
                visited++;
                stack[++top] = next;
                moved = true;
                break;
            }
            if (!moved) top--;           // төрт бағыт бітті: тұйық, бір қадам артқа
        }

        int[] path = top < 0 ? new int[0] : java.util.Arrays.copyOf(stack, top + 1);
        return new Result(path, visited, deadEnds);
    }

    /** d бағытындағы ұяшық (0 жоғары, 1 оң, 2 төмен, 3 сол) немесе -1, егер лабиринттен тыс болса. */
    private static int neighbour(int cell, int d, int rows, int cols) {
        int r = cell / cols, c = cell % cols;
        switch (d) {
            case 0:  return r > 0 ? cell - cols : -1;
            case 1:  return c < cols - 1 ? cell + 1 : -1;
            case 2:  return r < rows - 1 ? cell + cols : -1;
            default: return c > 0 ? cell - 1 : -1;
        }
    }

    private static boolean contains(int[] list, int x) {
        for (int v : list) if (v == x) return true;   // ұяшықта көбі 4 есік
        return false;
    }
}