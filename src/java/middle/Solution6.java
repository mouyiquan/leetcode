package middle;

/**
 * @author mango
 * @version 1.0
 * @description 6. Z 字形变换
 * https://leetcode.cn/problems/zigzag-conversion/
 * @email
 * @date 2022/7/12 18:08
 */
public class Solution6 {

    //模拟
    public String convert(String s, int numRows) {

        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        int t = r * 2 - 2;
        int c = (n + t - 1) / t * (r - 1);
        char[][] mat = new char[r][c];
        for (int i = 0, x = 0, y = 0; i < n; ++i) {
            mat[x][y] = s.charAt(i);
            if (i % t < r - 1) {
                ++x; // 向下移动
            } else {
                --x;
                ++y; // 向右上移动
            }
        }
        StringBuffer ans = new StringBuffer();
        for (char[] row : mat) {
            for (char ch : row) {
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }

}
