package dp;

/**
 * @author mango
 * @version 1.0
 * @description 62. 不同路径
 * @email
 * @date 2022/6/22 8:59
 */
public class Solution62 {

    public int uniquePaths(int m, int n) {

        int[][] paths = new int[m][n];

        paths[0][0] = 1;

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

}
