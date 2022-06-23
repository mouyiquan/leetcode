package other;

/**
 * @author mango
 * @version 1.0
 * @description 152. 乘积最大子数组
 * @email
 * @date 2022/4/19 10:21
 */
public class Solution152 {

    /**
     * 解题思路
     * 1.根据0分为多个区间段，每个区间段判断负数的数量
     * 2.将第一个到负数的乘积保存下来，将最后一个负数到最后的保存下来
     * 3.当区间段内存在奇数个负数时，区间段整个乘积去分别除前段负数和后段负数得最大值
     *
     * 1.包含 0
     * 2.负数奇数个：边值到最后一个负数的乘积（不包含最后一个负数）
     * 3.负数偶数个：所有的乘积
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = -11;
        int sum = 0;

        boolean first = true;
        int firstSum = 0;
        int firstNum = 0;

        //区间段
        int count = 0;

        boolean last = false;
        int lastSum = 0;
        int lastNum = 0;

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0){
                if (sum!=0 && firstSum != 0){

                    if (i-lastNum != 1 || (count > 1 && count%2 == 1)){
                        max = Math.max(max ,sum/firstSum);
                        max = Math.max(max ,sum/lastSum);
                    }

                    count = 0;

                    first = true;
                    firstSum = 0;
                    lastSum = 0;
                    last = false;
                }
                sum = 0;
                max = Math.max(max ,sum);
                continue;
            }
            if (sum == 0){
                sum = 1;
            }
            if (nums[i] < 0){
                count++;
                if (first){
                    firstNum = i;
                    first = false;
                    firstSum = sum * nums[i];
                }
                last = true;
                lastNum = i;
                lastSum = nums[i];

                sum = sum * nums[i];
                max = Math.max(max ,sum);
                continue;
            }
            if (nums[i] > 0){
                if (last){
                    last = false;
                }
                lastSum = lastSum * nums[i];

                sum = sum * nums[i];
                max = Math.max(max ,sum);
            }

        }
        if (firstSum != 0 ){
            if (nums.length - lastNum != 1 ||  (count > 1 && count%2 == 1)){
                max = Math.max(max ,sum/firstSum);
                max = Math.max(max ,sum/lastSum);
            }
        }

        if (max == -11){
            return 0;
        }

        return max;
    }

    public static void main(String[] args) {
        Solution152 solution152 = new Solution152();
        int[] test = new int[]{-1,-2,-3,0};
        System.out.println(solution152.maxProduct(test));
    }
}
