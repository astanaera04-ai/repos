package Learn_java;

import java.util.Arrays;
import java.util.Scanner;

public class esep22 {
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++){
            if (i == nums.length - 1) break;
            for (int j = i + 1; j < nums.length; j++){

                if ( nums[i] + nums[j] == target) return new int[] {i , j};

            }
        }

        return new int[] {};
    }

    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();

        int [] nums = new int[4];
        for(int i = 0; i < 4; i++){
            nums[i] = sc.nextInt();
        }

        int[] result = twoSum(nums, target);
        System.out.println("Жауап: " + Arrays.toString(result));
    }
}
