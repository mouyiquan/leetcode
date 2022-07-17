package middle;

/**
 * 565. 数组嵌套
 * https://leetcode.cn/problems/array-nesting/
 */
public class Solution565 {

    public static int arrayNesting(int[] nums) {

        Integer max = 0;
        int sum;
        int index;
        for (int i = 0; i < nums.length; i++) {
            index = i;
            sum = 0;
            while (nums[index] != -1 ){
                sum++;
                int tmp = nums[index];
                 nums[index] = -1;
                index = tmp;
                max = Integer.max(sum,max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2}));
    }
}
