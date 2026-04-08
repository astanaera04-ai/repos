package Learn_java;

import java.util.Arrays;
public class esep23 {

    public static void  moveZeroes(int[] nums){

        int insertPos = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }

        while (insertPos < nums.length){
            nums[insertPos] = 0;
            insertPos++;
        }
    }

    public static void main(String[] args) {


        int[] nums = {0, 1, 0, 3, 12};

        System.out.println("Бастапқы массив: " + Arrays.toString(nums));

        moveZeroes(nums);

        System.out.println("Нәтиже (0-дер соңында): " + Arrays.toString(nums));
    }
}