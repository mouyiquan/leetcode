package structure.problem334;

/**
 * 334. 递增的三元子序列
 */
public class Solution334 {
    public boolean increasingTriplet(int[] nums) {

        if (nums.length <= 2) {
            return false;
        }
        int min = nums[0];
        int middle = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>middle){
                return true;
            }else if (nums[i] > min){
                middle = nums[i];
            }else {
                min = nums[i];
            }

        }
        return false;
    }
}
