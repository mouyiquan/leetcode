package stack;

import java.util.Stack;

/**
 * @author mango
 * @version 1.0
 * @description 735. 行星碰撞
 * https://leetcode.cn/problems/asteroid-collision/
 * @email
 * @date 2022/7/13 9:05
 */
public class Solution735 {

    //1.栈
    public static int[] asteroidCollisionStack(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty()){
                stack.push(asteroids[i]);
                continue;
            }
            boolean flag = true;
            while (flag){
                Integer peek = stack.peek();
                if (peek <= asteroids[i]){
                    stack.add(asteroids[i]);
                    break;
                }
                //判断2个行星的方向是不是相同
                if ((peek>0 && asteroids[i]>0) || (peek<0 && asteroids[i]<0) ){
                    stack.add(asteroids[i]);
                    break;
                }
                Integer pop = stack.pop();
                if (Math.abs(pop) == Math.abs(asteroids[i])){
                    break;
                }
                if (pop > asteroids[i]){
                    if (Math.abs(pop) > Math.abs(asteroids[i])){
                        stack.add(pop);
                        break;
                    }
                }
                if (stack.isEmpty()){
                    stack.push(asteroids[i]);
                    flag = false;
                }
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    //2.双指针
//    public int[] asteroidCollision(int[] asteroids) {
//        for (int i = 0; i < asteroids.length; i++) {
//            asteroids
//        }
//
//    }

    public static void main(String[] args) {
        System.out.println(asteroidCollisionStack(new int[]{5, 10, -5}));
    }
}
