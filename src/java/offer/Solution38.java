package offer;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author mango
 * @version 1.0
 * @description 剑指 Offer 38. 字符串的排列
 * https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/
 * @email
 * @date 2022/6/30 8:52
 */
public class Solution38 {

    Set<String> set = new HashSet<>();

    public String[] permutation(String s) {

        //先取出所有的字符串
        dfs("", new LinkedList<Character>( s.chars().mapToObj(c -> (char) c).collect(Collectors.toList())));
        return set.toArray(new String[0]);
    }

    public void dfs(String a, List<Character> b){

        if (b.isEmpty()){
            set.add(a);
        }

        for (int i = 0; i < b.size(); i++) {
            List<Character> c = new ArrayList<>(b);
            c.remove(i);
            dfs(a + b.get(i) , c);
        }

    }


    public static void main(String[] args) {
        Solution38 solution38 = new Solution38();
        System.out.println(solution38.permutation("abc"));
    }
}
