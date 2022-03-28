package problem976;

import java.util.Arrays;

/**
 * @author mango
 * @version 1.0
 * @description 976. 三角形的最大周长
 * 给定由一些正数（代表长度）组成的数组 nums ，返回 由其中三个长度组成的、面积不为零的三角形的最大周长 。如果不能形成任何面积不为零的三角形，返回 0。
 * @email
 * @date 2022/3/28 9:24
 */
public class Solution976 {

    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; --i) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,2};
        int[] nums2 = new int[]{2,1,2};
        System.out.println(largestPerimeter(nums));
        System.out.println(largestPerimeter(nums2));
    }
}
