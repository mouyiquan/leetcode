package dp;

/**
 * @author mango
 * @version 1.0
 * @description 5. 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/
 * @email
 * @date 2022/6/28 9:37
 */
public class Solution5 {

    /**
     * 中心扩展法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        if (s.length()<=1){
            return s;
        }

        int start = 0;
        int end = 0;

        int length = s.length();

        for (int i = 0; i < length; i++) {
            int len1 = kuoshan(s, i, i);
            int len2 = kuoshan(s, i, i+1);
            int len = Math.max(len2, len1);
            if (len > end - start){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }

        return s.substring(start,end+1);
    }

    private Integer kuoshan(String s, int left, int right){
        while (left>0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}
