package univ_assignments.DAA_ASS_3;

public class DisjointSet {

    private final int[] parent;
    private final int[] size;   // size[r] = r түбірлі ағаштағы ұяшық саны
    private int sets;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        sets = n;
    }

    /** x жатқан жиынның түбірі. */
    public int find(int x) {
        // 1-өту: түбірге дейін көтерілу (рекурсия жоқ, цикл)
        int root = x;
        while (parent[root] != root) root = parent[root];
        // 2-өту: path compression, жолдағы бәрі түбірге тікелей бағытталады
        while (parent[x] != root) {
            int next = parent[x];
            parent[x] = root;
            x = next;
        }
        return root;
    }

    /** a және b жиындарын біріктіреді. Әр түрлі болса true, бұрыннан бір жиын болса false. */
    public boolean union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return false;
        if (size[ra] < size[rb]) { int t = ra; ra = rb; rb = t; }   // ra үлкен ағаш болады
        parent[rb] = ra;
        size[ra] += size[rb];
        sets--;
        return true;
    }

    public boolean connected(int a, int b) {
        return find(a) == find(b);
    }

    public int count() {
        return sets;
    }
}