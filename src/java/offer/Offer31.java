package offer;

import java.util.Stack;

/**
 * @author mango
 * @version 1.0
 * @description 剑指 Offer 31. 栈的压入、弹出序列
 * https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 * @email
 * @date 2022/6/30 8:34
 */
public class Offer31 {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        if (popped.length <= 2){
            return true;
        }
        Stack<Integer> stack = new Stack<>();

        int left = 0;
        for (int i = 0; i < pushed.length; i++) {

            stack.push(pushed[i]);

            while (!stack.isEmpty()  && stack.peek() == popped[left]){
                stack.pop();
                left++;
            }

        }

        if (left == pushed.length){
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }
}
