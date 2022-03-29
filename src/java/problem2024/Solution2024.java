package problem2024;

/**
 * @author mango
 * @version 1.0
 * @description TODO
 * @email
 * @date 2022/3/29 8:24
 */
public class Solution2024 {

    //方法1 滑动窗口
    //时间复杂度O(n)
    //空间复杂度O(1)
    //TODO 优化为方法,就不用复制代码了
    private static int maxConsecutiveAnswers(String answerKey, int k) {

        if (answerKey == null || answerKey.length()==0){
            return 0;
        }

        int length = answerKey.length();
        int left = 0;
        int right = 0;
        int res = 0;
        int zeros = 0;

        while (right < length){
            if (answerKey.charAt(right) == 'F'){
                zeros++;
            }
            while (zeros > k){

                if (answerKey.charAt(left) == 'F'){
                    zeros--;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }


        int left1 = 0;
        int right1 = 0;
        int res1 = 0;
        int zeros1 = 0;

        while (right1 < length){
            if (answerKey.charAt(right1) == 'T'){
                zeros1++;
            }
            while (zeros1 > k){

                if (answerKey.charAt(left1) == 'T'){
                    zeros1--;
                }
                left1++;
            }
            res1 = Math.max(res1, right1 - left1 + 1);
            right1++;
        }

        return Math.max(res ,res1);
    }


    //方法2
    // 查找 所有要替换的下标
    // 替换 连续的两个下标
    // 拆分 根据替换字符拆分成数组
    // 循环 循环数组，获取最大的字符串长度
    // 空间复杂度 O(n)
    // 时间复杂度 O(n^2)


    public static void main(String[] args) {
        System.out.println(maxConsecutiveAnswers("TTFF",2));
        System.out.println(maxConsecutiveAnswers("TFFT",1));
        System.out.println(maxConsecutiveAnswers("TTFTTFTT",1));

    }
}
