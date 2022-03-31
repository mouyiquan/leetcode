package problem1672;

/**
 * @author mango
 * @version 1.0
 * @description TODO
 * @email
 * @date 2022/3/31 10:40
 */
public class Solution1672 {

    public int maximumWealth(int[][] accounts) {
        int summax=0;
        for(int i=0;i<accounts.length;i++){
            int sum=0;
            for(int j=0;j<accounts[0].length;j++){
                sum+=accounts[i][j];//求和
            }
            summax=Math.max(summax,sum);//取最值
        }
        return summax;
    }

}
