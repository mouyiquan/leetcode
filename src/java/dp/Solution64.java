package dp;

/**
 * @author mango
 * @version 1.0
 * @description 64. 最小路径和
 * https://leetcode.cn/problems/minimum-path-sum/
 * @email
 * @date 2022/7/4 8:52
 */
public class Solution64 {

    public static int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] sum = new int[m+1][n+1];
        sum[1][0] = 0;
        sum[0][1] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1){
                    sum[i][j] = sum[i][j-1] + grid[i-1][j-1];
                    continue;
                }
                if (j == 1){
                    sum[i][j] = sum[i-1][j] + grid[i-1][j-1];
                    continue;
                }

                int max = Math.min(sum[i][j-1] , sum[i-1][j]);
                sum[i][j] = max + grid[i-1][j-1];
            }
        }

        return sum[m][n];

    }


    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
