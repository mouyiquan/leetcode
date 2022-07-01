package middle;

import java.util.*;

/**
 * @author mango
 * @version 1.0
 * @description 241. 为运算表达式设计优先级
 * https://leetcode.cn/problems/different-ways-to-add-parentheses/
 * @email
 * @date 2022/7/1 8:40
 */
public class Solution241 {

    Map<String,List<Integer>> map = new HashMap<>();

    //该方法不能通过，自己加了部分优化代码，但是和预期结果不一致，正确答案已经提交
    //分治法
    public List<Integer> diffWaysToCompute(String expression) {

        if (map.containsKey(expression)){
            return map.get(expression);
        }

        boolean containJia = expression.contains("+");
        boolean containJian = expression.contains("-");
        boolean containChen = expression.contains("*");

        ArrayList<Integer> integers = new ArrayList<>();
        //如果都为false表示为数字
        if (!containJia && !containJian && !containChen){
            integers.add(Integer.parseInt(expression));
            map.put(expression, integers);
            return integers;
        }

        //先判断是否表达式只包含一种算数运算符号，如果是，则直接运算
        //全是加
        if (containJia && !containJian && !containJian){
            String[] split = expression.split("[+]");
            int sum = 0;
            for (String s : split) {
                sum += Integer.parseInt(s);
            }
            integers.add(sum);
            map.put(expression,integers);
            return integers;
        }
        //全是减
        if (!containJia && containJian && !containJian){
            String[] split = expression.split("[-]");
            int sum = 0;
            for (String s : split) {
                sum -= Integer.parseInt(s);
            }
            integers.add(sum);
            map.put(expression,integers);
            return integers;
        }
        //全是乘
        if (!containJia && !containJian && containJian){
            String[] split = expression.split("[*]");
            int sum = 1;
            for (String s : split) {
                sum *= Integer.parseInt(s);
            }
            integers.add(sum);
            map.put(expression,integers);
            return integers;
        }

        //计算结果集
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '-' || c == '+' || c == '*'){
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                if (c=='-'){
                    for (int i1 = 0; i1 < left.size(); i1++) {
                        for (int i2 = 0; i2 < right.size(); i2++) {
                            integers.add(left.get(i1) - right.get(i2));
                        }
                    }
                }
                if (c=='+'){
                    for (int i1 = 0; i1 < left.size(); i1++) {
                        for (int i2 = 0; i2 < right.size(); i2++) {
                            integers.add(left.get(i1) + right.get(i2));
                        }
                    }
                }
                if (c=='*'){
                    for (int i1 = 0; i1 < left.size(); i1++) {
                        for (int i2 = 0; i2 < right.size(); i2++) {
                            integers.add(left.get(i1) * right.get(i2));
                        }
                    }
                }

            }
        }


        return integers;
    }


}
