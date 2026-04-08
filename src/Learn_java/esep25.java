package Learn_java;
import java.util.Arrays;

public class esep25 {

    public static int remnum(int[] nums, int val){
        int s = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[s] = nums[i];
                s++;
            }
        }
        return s;
    }

    static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;

        System.out.println("Bastapky tyzym: ");
        System.out.print(Arrays.toString(nums));

        int a = remnum(nums,val);
        System.out.println();

        System.out.print("Өзгерген массивтің басы: [");
        for (int i = 0; i < a; i++){
            System.out.print(nums[i] + (i == a - 1 ? "" : ", "));
        }
        System.out.println("]");
    }

}
