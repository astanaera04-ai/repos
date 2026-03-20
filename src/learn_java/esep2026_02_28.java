package learn_java;

import java.util.Arrays; // Массивті консольға әдемілеп шығару үшін керек

public class esep2026_02_28 {

    public void moveZeroes(int[] nums) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {

                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;

                k++;
            }
        }
    }

    public static void main(String[] args) {
        esep2026_02_28 esep = new esep2026_02_28();

        int[] testArray = { 1, 0, 3, 12};

        System.out.println("Бастапқы массив: " + Arrays.toString(testArray));

        esep.moveZeroes(testArray);

        System.out.println("Өзгерген массив: " + Arrays.toString(testArray));
    }
}