package Learn_java;

import java.util.Arrays;

public class esep24 {

    public static int removeDuplicates(int[] nums){
        int insertPos = 1;
        for(int i = 1; i < nums.length; i++){

            if (nums[i] != nums[i - 1]){
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }

        return insertPos;
    }

    static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        System.out.println("Бастапқы массив: " + Arrays.toString(nums));

        int a = removeDuplicates(nums);

        System.out.println("Өзгерген массивтің басы: [");
        for (int i = 0; i < a; i++){
            System.out.print(nums[i] + (i == a - 1 ? "" : ", "));
        }
        System.out.println("]");
    }
}
