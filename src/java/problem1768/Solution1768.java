package problem1768;

/**
 * @author mango
 * @version 1.0
 * @description 1768. 交替合并字符串
 * @email
 * @date 2022/4/2 10:33
 */
public class Solution1768 {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length(), idx = 0;
        char[] res = new char[len1 + len2];
        for(int i = 0; i < len1 || i < len2; ++i) {
            if(i < len1) {
                res[idx++] = word1.charAt(i);
            }
            if(i < len2) {
                res[idx++] = word2.charAt(i);
            }
        }
        return new String(res);
    }
}
