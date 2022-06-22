package dp;

/**
 * @author mango
 * @version 1.0
 * @description 63. 不同路径 II
 * @email
 * @date 2022/6/22 8:59
 */
public class Solution63 {

    public int uniquePaths(int m, int n) {

        int[][] paths = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0){
                    paths[i][j] = 1;
                }else {
                    paths[i][j] = paths[i-1][j] + paths[i][j-1];
                }

            }
        }

        return paths[m-1][n-1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                if (i == 0) {
                    if (j == 0) {
                        obstacleGrid[i][j] = 1;
                    } else {
                        obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                    }
                    continue;
                }
                if (j == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                    continue;
                }

                obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }

        }
        return obstacleGrid[m - 1][n - 1];
    }
}
