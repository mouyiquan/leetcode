package problem240;

/**
 * @author mango
 * @version 1.0
 * @description  剑指 Offer 04. 二维数组中的查找
 * @email
 * @date 2022/6/7 11:24
 */
public class Solution240 {

    //典型 Z 字型搜索
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }

}
