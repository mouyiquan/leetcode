package problem1004;

/**
 * @author mango
 * @version 1.0
 * @description 1004. 最大连续1的个数 III
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * @email
 * @date 2022/3/29 10:00
 */
public class Solution1004 {

    private static int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeros = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                zeros++;
            }
            while (zeros > k){
                if (nums[left] == 0){
                    zeros--;
                }
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        System.out.println(longestOnes(nums, k));
    }

}
