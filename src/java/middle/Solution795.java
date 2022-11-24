package middle;

public class Solution795 {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        //当前区间最大的长度
        int rightIndex = 0;
        //当前非法的长度
        int rongIndex = 0;
        int rongSum = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            //获取当前值的最大值
            max = Math.max(max, nums[i]);
            if (right >= max){
                rightIndex++;
                if (nums[i] >= left && right >= nums[i]){
                    if (rongIndex > 0){
                        rongSum += calculateSum(rongIndex);
                        rongIndex = 0;
                    }
                }else {
                    rongIndex++;
                }
            }else {
                if (rightIndex > 0){
                    sum += calculateSum(rightIndex);
                    rightIndex = 0;
                }
                if (rongIndex > 0){
                    rongSum += calculateSum(rongIndex);
                    rongIndex = 0;
                }
                max = Integer.MIN_VALUE;
            }
        }
        if (rightIndex > 0){
            sum += calculateSum(rightIndex);
        }
        if (rongIndex > 0){
            rongSum += calculateSum(rongIndex);
        }
        return sum - rongSum;
    }

    private int calculateSum(int value){
        int result = 0;
        for (int i = 1; i <= value; i++) {
            result = i + result;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {876,880,482,260,132,421,732,703,795,420,871,445,400,291,358,589,617,202,755,810,227,813,549,791,418,528,835,401,526,584,873,662,13,314,988,101,299,816,833,224,160,852,179,769,646,558,661,808,651,982,878,918,406,551,467,87,139,387,16,531,307,389,939,551,613,36,528,460,404,314,66,111,458,531,944,461,951,419,82,896,467,353,704,905,705,760,61,422,395,298,127,516,153,299,801,341,668,598,98,241};
        Solution795 solution795 = new Solution795();
        //19
        System.out.println(solution795.numSubarrayBoundedMax(nums, 658, 719));
    }
}
