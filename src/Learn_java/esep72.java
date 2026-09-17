package Learn_java;

import java.util.Arrays;
public class esep72 {
    public static void main(String[] args) {

        long s = 253004;
        for (int i = 0; i < 5; i++)
            s = (s * 75 + 74) % 65537;

        int[] a = new int[24];
        for (int i = 0; i < 24; i++) {
            s = (s * 75 + 74) % 65537; long h = s;
            s = (s * 75 + 74) % 65537;
            a[i] = (int) ((h * 65537 + s) % 1_000_000L) + 1;
        }

        long total = 0;
        for (int x : a) total += x;
        System.out.println("Жалпы қосынды: " + total);
        System.out.print("Алғашқы 6 сан: ");
        for (int i = 0; i < 6; i++) System.out.print(a[i] + " ");
        System.out.println("\n");


        //  STAGE A
        int[] sorted = a.clone();
        for (int i = 0; i < sorted.length - 1; i++)
            for (int j = i + 1; j < sorted.length; j++)
                if (sorted[j] > sorted[i]) {
                    int tmp = sorted[i]; sorted[i] = sorted[j]; sorted[j] = tmp;
                }

        boolean[] groupA = new boolean[24];
        long sumA = 0, sumB = 0;
        for (int i = 0; i < 24; i++) {
            if (sumA <= sumB) { groupA[i] = true;  sumA += sorted[i]; }
            else              { groupA[i] = false; sumB += sorted[i]; }
        }
        long scoreA = Math.abs(sumA - sumB);
        System.out.println("=== STAGE A — Greedy ===");
        System.out.println("Sum A: " + sumA);
        System.out.println("Sum B: " + sumB);
        System.out.println("Score A: " + scoreA + "\n");


        //  STAGE B
        boolean improved = true;
        int swaps = 0;

        while (improved) {
            improved = false;
            for (int i = 0; i < 24; i++) {
                for (int j = 0; j < 24; j++) {
                    if (groupA[i] == groupA[j]) continue;

                    long nA, nB;
                    if (groupA[i]) {
                        nA = sumA - sorted[i] + sorted[j];
                        nB = sumB - sorted[j] + sorted[i];
                    } else {
                        nA = sumA - sorted[j] + sorted[i];
                        nB = sumB - sorted[i] + sorted[j];
                    }

                    if (Math.abs(nA - nB) < Math.abs(sumA - sumB)) {
                        sumA = nA; sumB = nB;
                        boolean tmp = groupA[i];
                        groupA[i] = groupA[j];
                        groupA[j] = tmp;
                        improved = true;
                        swaps++;
                    }
                }
            }
        }
        long scoreB = Math.abs(sumA - sumB);
        System.out.println(" STAGE B  ");
        System.out.println("Sum A: " + sumA);
        System.out.println("Sum B: " + sumB);
        System.out.println("Score B: " + scoreB);
        System.out.println("Swaps: " + swaps);
    }
}
