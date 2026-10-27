package univ_assignments.DAA_ASS_3;

public class DisjointSetTest {

    static int failed = 0;

    static void check(boolean ok, String what) {
        System.out.println((ok ? "ok    " : "FAIL  ") + what);
        if (!ok) failed++;
    }

    public static void main(String[] args) {
        DisjointSet d = new DisjointSet(6);
        check(d.count() == 6, "6 sets at the start");
        check(!d.connected(0, 1), "0 and 1 are apart at the start");
        check(d.union(0, 1), "union(0, 1) joins two sets");
        check(d.connected(0, 1), "0 and 1 are together");
        check(!d.union(1, 0), "union(1, 0) again returns false");
        check(d.count() == 5, "5 sets after one union");
        d.union(2, 3); d.union(1, 3);
        check(d.connected(0, 2), "0 and 2 are together through 1 and 3");
        check(d.count() == 3, "3 sets: {0,1,2,3} {4} {5}");
        check(d.find(4) == 4 && d.find(5) == 5, "a single cell is its own root");

        // my own checks
        check(!d.union(2, 2), "union of a cell with itself returns false");
        check(d.count() == 3, "count does not change after a useless union");

        DisjointSet chain = new DisjointSet(1_000_000);
        boolean allTrue = true;
        for (int i = 0; i + 1 < 1_000_000; i++) allTrue &= chain.union(i, i + 1);   // a long chain of unions
        check(allTrue, "999999 unions of a chain all return true");
        check(chain.count() == 1, "one set after joining a chain of 1000000 cells");
        check(chain.connected(0, 999_999), "the ends of the long chain are connected (no stack overflow)");
        check(chain.find(123_456) == chain.find(999_999), "find gives the same root for every cell of one set");

        DisjointSet e = new DisjointSet(8);
        for (int i = 0; i < 7; i += 2) e.union(i, i + 1);       // {0,1} {2,3} {4,5} {6,7}
        check(e.count() == 4, "4 sets after 4 unions of pairs");
        e.union(0, 2); e.union(4, 6); e.union(1, 7);            // everything is joined
        check(e.count() == 1, "1 set after joining all the pairs");
        check(!e.union(3, 5), "union inside the big set returns false");

        DisjointSet one = new DisjointSet(1);
        check(one.count() == 1 && one.find(0) == 0, "a set of a single cell works");

        System.out.println(failed == 0 ? "All checks passed." : failed + " checks failed.");
    }
}
