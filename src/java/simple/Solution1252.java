package simple;

/**
 * @author mango
 * @version 1.0
 * @description 1252. 奇数值单元格的数目
 * https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix/
 * @email
 * @date 2022/7/12 7:45
 */
public class Solution1252 {

    public int oddCells(int m, int n, int[][] indices) {

        int[] r = new int[indices.length];
        int[] c = new int[indices[0].length];

        for (int i = 0; i < indices.length; i++) {
            r[indices[i][0]]++;
            c[indices[i][1]]++;
        }

        int oddx = 0, oddy = 0;
        for (int i = 0; i < m; i++) {
            if ((r[i] & 1) != 0) {
                oddx++;
            }
        }
        for (int i = 0; i < n; i++) {
            if ((c[i] & 1) != 0) {
                oddy++;
            }
        }
        return oddx * (n - oddy) + (m - oddx) * oddy;
    }

}
