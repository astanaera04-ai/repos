package univ_assignments.ADS_ASS_3;

import java.util.Random;

public class Sorter {

    //  BASIC SORT: Bubble Sort

    public void basicSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // early-exit optimisation

            // After each pass, the last (i) elements are already sorted
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap adjacent elements
                    int temp = arr[j];
                    arr[j]     = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }

    //  ADV  Quick Sort

    public void advancedSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i     = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i]   = arr[j];
                arr[j]   = temp;
            }
        }


        int temp    = arr[i + 1];
        arr[i + 1]  = arr[high];
        arr[high]   = temp;

        return i + 1;
    }

    public void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public int[] generateRandomArray(int size) {
        Random random = new Random(42);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(10_000);
        }
        return arr;
    }

    public int[] generateSortedArray(int size) {
        int[] arr = generateRandomArray(size);
        advancedSort(arr);
        return arr;
    }

    public int[] copyArray(int[] arr) {
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        return copy;
    }
}
