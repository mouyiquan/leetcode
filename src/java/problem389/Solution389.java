package problem389;

/**
 * @author mango
 * @version 1.0
 * @description 389. 找不同
 * @email
 * @date 2022/4/2 10:35
 */
public class Solution389 {

    //1.利用ASC码计算
    public char findTheDifference(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);

    }

    //2.利用ASC + 位运算
    public char findTheDifference2(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            ret ^= t.charAt(i);
        }
        return (char) ret;
    }
}
