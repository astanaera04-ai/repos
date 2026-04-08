package Learn_java;

public class esep28 {
    public static double findMaxAverage(int[] nums, int k){

        int sum1 = 0;
        int sum2 = Integer.MIN_VALUE;
        for (int i = 0; i <= nums.length - k; i++){
            sum1 = 0;
            for (int j = i; j < i + k; j++){
                sum1 += nums[j];

            }
            if (sum1 >= sum2){
                sum2 = sum1;
            }
        }
        return (double) sum2 / k;
    }

    static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        System.out.println("Ең үлкен орташа мән: " + findMaxAverage(nums, k));
    }
    
}
