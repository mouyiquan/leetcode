package queue.problem385;

/**
 * @author mango
 * @version 1.0
 * @description 385. 迷你语法分析器
 * @email
 * @date 2022/4/15 8:46
 */
public class Solution385 {
    public NestedInteger deserialize(String s) {
        int length = s.length();

        NestedInteger tmp = new NestedInteger();
        NestedInteger nestedInteger = tmp;

        if (length == 0){
            return nestedInteger;
        }

        if ('[' != s.charAt(0)){
            int sum = 0;

            for (int i = length -1; i > 0; i--) {
                int cnt = Integer.parseInt(String.valueOf(s.charAt(i)));
                for (int j = 0; j < length - 1 - i; j++) {
                    cnt = cnt * 10;
                }
                sum+=cnt;
            }

            if ('-' == s.charAt(0)){
                sum *= -1;
            }else {
                int cnt = Integer.parseInt(String.valueOf(s.charAt(0)));
                for (int j = 0; j < length-1; j++) {
                    cnt = cnt * 10;
                }
                sum+=cnt;
            }

            return new NestedInteger(sum);
        }


        //双指针存入队列
        int left = 0;
        int right = 0;
        while (right < length){
            if (s.charAt(right) == '['){
                right++;
                left = right;
                continue;
            }
            String sub = null;
            if (s.charAt(right) == ','){
                sub = s.substring(left,right);
                right++;
                left = right;
            }

            if (s.charAt(right) == ']'){
                sub = s.substring(left,right);
                right = length;
            }

            if (sub != null){
                NestedInteger aa = new NestedInteger();
                aa.setInteger(Integer.parseInt(sub));
                tmp.add(aa);
                tmp = aa;
            }else {
                right++;
            }
        }

        return nestedInteger.getList().get(0);
    }

    public static void main(String[] args) {
        //输入：s = "[123,[456,[789]]]",
        //输出：[123,[456,[789]]]

        Solution385 solution385 = new Solution385();
        NestedInteger deserialize = solution385.deserialize("[123,[456,[789]]]");
        System.out.println(deserialize);
    }
}
