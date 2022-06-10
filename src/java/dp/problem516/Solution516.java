package dp.problem516;

/**
 * @author mango
 * @version 1.0
 * @description TODO
 * @email
 * @date 2022/6/10 8:26
 */
public class Solution516 {
    public int longestPalindromeSubSeq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }


    public int longestPalindromeSubSeqNew(String s) {

        int n = s.length();

        int[][] dp = new int[n][n];
        for (int i = n-1; i >=0 ; i--) {
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            for (int j = i+1;i<n ;i++){
                char c2 = s.charAt(j);
                if (c1 == c2){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
