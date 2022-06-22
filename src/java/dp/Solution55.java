package dp;

/**
 * @author mango
 * @version 1.0
 * @description 55. 跳跃游戏
 * https://leetcode.cn/problems/jump-game/
 * @email
 * @date 2022/6/22 8:59
 */
public class Solution55 {


    /**
     * 动态规划
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1){
            return true;
        }

        Boolean[] f = new Boolean[nums.length];

        //初始状态
        f[0] = true;
        for (int i = 1; i < nums.length; i++) {
            f[i] = false;
            for (int j = 0; j < i; j++) {

                //枚举
                //当前面有一个台阶能够跳跃到当前，则当前index为true
                if (f[j] && j + nums[j] >= i){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[nums.length-1];
    }


    /**
     * 贪心
     * @param nums
     * @return
     */
    public static boolean canJump2(int[] nums) {
        if (nums.length == 1){
            return true;
        }

        //记录最远距离
        int maxDistance = nums[0];


        for (int i = 1; i < nums.length; i++) {
            if (i > maxDistance){
                return false;
            }
            if (nums[i] + i >= maxDistance){
                maxDistance = nums[i] + i;
            }
        }

        if (maxDistance < nums.length-1){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(canJump2(new int[]{2, 0, 0}));
    }
}
