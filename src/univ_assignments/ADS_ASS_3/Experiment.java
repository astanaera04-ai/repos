package univ_assignments.ADS_ASS_3;


public class Experiment {

    private final Sorter   sorter   = new Sorter();
    private final Searcher searcher = new Searcher();

    // Array sizes for exper
    private static final int SMALL  = 10;
    private static final int MEDIUM = 100;
    private static final int LARGE  = 1000;

    public long measureSortTime(int[] arr, String type) {
        int[] copy = sorter.copyArray(arr); // never mutate the original

        long start = System.nanoTime();

        if (type.equalsIgnoreCase("basic")) {
            sorter.basicSort(copy);       // Bubble Sort
        } else {
            sorter.advancedSort(copy);    // Quick Sort
        }

        long end = System.nanoTime();
        return end - start;
    }

    public long measureSearchTime(int[] arr, int target) {
        long start = System.nanoTime();
        searcher.search(arr, target);
        long end   = System.nanoTime();
        return end - start;
    }

    /**
     * Runs all performance experiments:
     *  – Bubble Sort vs Quick Sort on random arrays (small/medium/large)
     *  – Bubble Sort vs Quick Sort on sorted arrays (small/medium/large)
     *  – Linear Search on random arrays (small/medium/large)
     *  – Linear Search on sorted arrays (small/medium/large)
     */
    public void runAllExperiments() {

        System.out.println("=".repeat(65));
        System.out.println("       ALGORITHM PERFORMANCE EXPERIMENT");
        System.out.println("=".repeat(65));

        System.out.println("\n>>> SORTING EXPERIMENTS");
        System.out.println("-".repeat(65));

        int[] sizes = {SMALL, MEDIUM, LARGE};

        // Random arrays
        System.out.println("\n[INPUT TYPE: RANDOM ARRAY]");
        printSortHeader();

        for (int size : sizes) {
            int[] randomArr = sorter.generateRandomArray(size);
            long bubbleTime = measureSortTime(randomArr, "basic");
            long quickTime  = measureSortTime(randomArr, "advanced");
            printSortRow(size, "Random", bubbleTime, quickTime);
        }

        //  Pre-sorted arrays
        System.out.println("\n[INPUT TYPE: SORTED ARRAY]");
        printSortHeader();

        for (int size : sizes) {
            int[] sortedArr = sorter.generateSortedArray(size);
            long bubbleTime = measureSortTime(sortedArr, "basic");
            long quickTime  = measureSortTime(sortedArr, "advanced");
            printSortRow(size, "Sorted", bubbleTime, quickTime);
        }

        //SEAR EXPERIMENTS
        System.out.println("\n>>> SEARCHING EXPERIMENTS (Linear Search)");
        System.out.println("-".repeat(65));

        System.out.println("\n[INPUT TYPE: RANDOM ARRAY]");
        printSearchHeader();

        for (int size : sizes) {
            int[] randomArr = sorter.generateRandomArray(size);
            // Search for last element (worst-case scenario)
            int target      = randomArr[size - 1];
            long searchTime = measureSearchTime(randomArr, target);
            int  foundIdx   = searcher.search(randomArr, target);
            printSearchRow(size, "Random", target, foundIdx, searchTime);
        }

        // -- Sorted arrays --
        System.out.println("\n[INPUT TYPE: SORTED ARRAY]");
        printSearchHeader();

        for (int size : sizes) {
            int[] sortedArr = sorter.generateSortedArray(size);
            int target      = sortedArr[size - 1]; // last element → worst case
            long searchTime = measureSearchTime(sortedArr, target);
            int  foundIdx   = searcher.search(sortedArr, target);
            printSearchRow(size, "Sorted", target, foundIdx, searchTime);
        }

        System.out.println("\n" + "=".repeat(65));
        System.out.println("           EXPERIMENTS COMPLETE");
        System.out.println("=".repeat(65));
    }

    private void printSortHeader() {
        System.out.printf("%-8s %-10s %-22s %-22s%n",
                "Size", "Type", "Bubble Sort (ns)", "Quick Sort (ns)");
        System.out.println("-".repeat(65));
    }

    private void printSortRow(int size, String type, long bubble, long quick) {
        System.out.printf("%-8d %-10s %-22d %-22d%n", size, type, bubble, quick);
    }

    private void printSearchHeader() {
        System.out.printf("%-8s %-10s %-10s %-8s %-18s%n",
                "Size", "Type", "Target", "Index", "Linear Search (ns)");
        System.out.println("-".repeat(65));
    }

    private void printSearchRow(int size, String type, int target, int idx, long time) {
        String indexStr = (idx == -1) ? "Not found" : String.valueOf(idx);
        System.out.printf("%-8d %-10s %-10d %-8s %-18d%n",
                size, type, target, indexStr, time);
    }
}