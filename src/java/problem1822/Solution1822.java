package problem1822;

/**
 * @author mango
 * @version 1.0
 * @description 1822. 数组元素积的符号
 * @email
 * @date 2022/3/28 9:56
 */
public class Solution1822 {

    public int arraySign(int[] nums) {
        int sign=1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<0) {
                sign*=-1;
            }
            if(nums[i]==0) {
                return 0;
            }
        }
        return sign;
    }

}
