package univ_assignments.ADS_ASS_3;

public class Main {

    public static void main(String[] args) {

        Sorter   sorter   = new Sorter();
        Searcher searcher = new Searcher();
        Experiment experiment = new Experiment();

        System.out.println("=".repeat(65));
        System.out.println("   PART 1 — ALGORITHM DEMONSTRATION (small arrays)");
        System.out.println("=".repeat(65));

        //Bub Sort
        System.out.println("\n Bub Sort ");
        int[] bubbleArr = sorter.generateRandomArray(10);
        System.out.print("Before: ");
        sorter.printArray(bubbleArr);

        long bStart = System.nanoTime();
        sorter.basicSort(bubbleArr);
        long bEnd = System.nanoTime();

        System.out.print("After:  ");
        sorter.printArray(bubbleArr);
        System.out.println("Time: " + (bEnd - bStart) + " ns");

        //Quick
        System.out.println("\n Quic Sort ");
        int[] quickArr = sorter.generateRandomArray(10);
        System.out.print("Before: ");
        sorter.printArray(quickArr);

        long qStart = System.nanoTime();
        sorter.advancedSort(quickArr);
        long qEnd = System.nanoTime();

        System.out.print("After:  ");
        sorter.printArray(quickArr);
        System.out.println("Time: " + (qEnd - qStart) + " ns");

        // Lin Sear
        System.out.println("\n Lin Search ");
        int[] searchArr = sorter.generateRandomArray(10);
        int   target    = searchArr[7];
        System.out.print("Array:  ");
        sorter.printArray(searchArr);
        System.out.println("Target: " + target);

        long sStart = System.nanoTime();
        int  index  = searcher.search(searchArr, target);
        long sEnd   = System.nanoTime();

        if (index != -1) {
            System.out.println("Found at index: " + index);
        } else {
            System.out.println("Target not found.");
        }
        System.out.println("Time: " + (sEnd - sStart) + " ns");

        System.out.println("\n");
        experiment.runAllExperiments();
    }
}
