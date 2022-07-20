package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mango
 * @version 1.0
 * @description 22. 括号生成
 * https://leetcode.cn/problems/generate-parentheses/
 * @email
 * @date 2022/7/20 9:16
 */
public class Solution22 {

    public static List<String> generateParenthesis(int n) {


        ArrayList<String> strings = new ArrayList<>();
        generateParenthesis(strings,"(",n-1,n);
        return strings;
    }

    private static void generateParenthesis(List<String> list, String sub, int left,int right){
        if ( left == 0 && right == 0){
            list.add(sub);
        } else if (left == 0){
            sub = sub + ")";
            generateParenthesis(list,sub,0,right-1);
        }else {

            if (right == left){
                generateParenthesis(list, sub + "(",left-1,right);
            }else {
                generateParenthesis(list, sub + "(",left-1,right);
                generateParenthesis(list,sub + ")",left,right-1);
            }
        }
    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }
}
