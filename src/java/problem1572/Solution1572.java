package problem1572;

/**
 * @author mango
 * @version 1.0
 * @description TODO
 * @email
 * @date 2022/4/1 15:51
 */
public class Solution1572 {
    public int diagonalSum(int[][] mat) {
        int n = mat.length, sum = 0, mid = n / 2;
        for (int i = 0; i < n; ++i) {
            sum += mat[i][i] + mat[i][n - 1 - i];
        }
        return sum - mat[mid][mid] * (n & 1);
    }
}
