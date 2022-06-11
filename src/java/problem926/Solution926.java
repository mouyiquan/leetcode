package problem926;

public class Solution926 {

    //前缀和
    public int minFlipsMonoIncr(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int ans = n;
        int[] sum = new int[n + 10];

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + (cs[i - 1] - '0');
        }

        for (int i = 1; i <= n; i++) {
            int l = sum[i - 1], r = (n - i) - (sum[n] - sum[i]);
            ans = Math.min(ans, l + r);
        }
        return ans;
    }

    //动态规划
    public int minFlipsMonoIncr2(String s) {
        int n = s.length();
        int dp0 = 0, dp1 = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int dp0New = dp0, dp1New = Math.min(dp0, dp1);
            if (c == '1') {
                dp0New++;
            } else {
                dp1New++;
            }
            dp0 = dp0New;
            dp1 = dp1New;
        }
        return Math.min(dp0, dp1);
    }
}
