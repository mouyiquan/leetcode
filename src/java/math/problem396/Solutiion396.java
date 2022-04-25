package math.problem396;

/**
 * @author mango
 * @date 2022/4/22 7:13
 * @version 1.0
 * @description: 396. 旋转函数
 */
public class Solutiion396 {

    /**
     *  nums = [4,3,2,6]
     *  nums{0} = [4,3,2,6]
     *  nums{1} = [6,4,3,2]
     *  nums{2} = [2,6,4,3]
     *  nums{3} = [3,2,6,4]
     *  规律：F(1) = F(0) + sum(nums) - nums.length * (最后一个数)
     * @param nums
     * @return
     */
    public int maxRotateFunction(int[] nums) {
        //f0不旋转时的值
        int f0 = 0;
        //累计值sum(nums)
        int sum = 0;
        //返回的最大值
        int maxNumber = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            f0 += i * nums[i];
            //累计（sum（num））
            sum+=nums[i];
        }
        maxNumber = f0;

        //循环判断
        for (int i = 1; i < length; i++) {
            f0 = f0 + sum - length * nums[length-i];
            maxNumber = Math.max(maxNumber, f0);
        }

        return maxNumber;
    }
}
