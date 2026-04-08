package Learn_java;

public class esep18 {
    public int searchInsert(int[] nums, int target) {

        for(int i=0; i < nums.length; i++){
            if(nums[i] >= target){
                return i;
            } else if (i+1 == nums.length) {
                return i+1;
            }
            else if(nums[i] < target && nums[i+1] > target){
                return i+1;
            }
            return 0;
        }
        return target;
    }

}
