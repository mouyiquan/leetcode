package stack.problem32;

import java.util.Deque;
import java.util.LinkedList;
/**
 * @author mango
 * @version 1.0
 * @description 32. 最长有效括号
 * @email
 * @date 2022/4/19 8:28
 */
public class Solution32 {

    //栈
    public int longestValidParenthesesByStack(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    //双循环+双指针
    public int longestValidParentheses(String s) {

        int left = 0;
        int right = 0;
        int maxLength = 0;
        char[] chars = s.toCharArray();

        //从左往右进行统计
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '('){
                left++;
            }else {
                right++;
            }
            //如果数量相等则表示匹配
            if (left == right){
                maxLength = Math.max(maxLength, 2 * right);
            }
            //如果right>left表示非法
            if (right > left){
                right = left = 0;
            }
        }

        right = left = 0;
        //从右往左进行统计
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ')'){
                right++;
            }else {
                left++;
            }
            //如果数量相等则表示匹配
            if (left == right){
                maxLength = Math.max(maxLength, 2 * left);
            }
            //如果right 《 left表示非法
            if (left > right){
                right = left = 0;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        System.out.println(solution32.longestValidParentheses("(()"));
        System.out.println(solution32.longestValidParenthesesByStack("))"));
    }
}
