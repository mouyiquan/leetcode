package problem283;

/**
 * @author mango
 * @version 1.0
 * @description 283. 移动零
 * @email
 * @date 2022/3/31 10:32
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
