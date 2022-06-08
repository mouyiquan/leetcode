package problem75;

/**
 * @author mango
 * @version 1.0
 * @description 75. 颜色分类
 * @email
 * @date 2022/6/8 9:09
 */
public class Solution75 {

    public static void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; ++i) {
            while (i <= p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }

    }

    public static void main(String[] args) {
        sortColors(new int[]{1,2,0});
    }
}
