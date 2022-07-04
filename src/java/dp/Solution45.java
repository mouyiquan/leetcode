package dp;

/**
 * @author mango
 * @version 1.0
 * @description 45. 跳跃游戏 II
 * https://leetcode.cn/problems/jump-game-ii/
 * @email
 * @date 2022/7/4 11:11
 */
public class Solution45 {


    //贪心
    public int jump(int[] nums) {

        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int step = 0;

        for (int i = 0; i < length; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end){
                end = maxPosition;
                step++;
            }
        }

        return step;
    }


    //动态规划 反向
    public static int jump2(int[] nums) {

        int length = nums.length;

        int[] jump = new int[length];

        //到达第一个位置不需要跳跃
        for (int i = length-1; i >= 0; i--) {
            if (i == length-1){
                jump[length-1] = 0;
            }else {
                jump[i] = Integer.MAX_VALUE;
            }
            for (int j = i+1; nums[i] >= j - i && j < length; j++) {
                jump[i] = Math.min(jump[i],jump[j] + 1);
            }
        }

        return jump[0];
    }

    public static void main(String[] args) {
        System.out.println(jump2(new int[]{2,3,1,1,4}));
    }
}
