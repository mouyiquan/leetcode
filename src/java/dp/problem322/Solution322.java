package dp.problem322;

import java.util.Arrays;

/**
 * @author mango
 * @version 1.0
 * @description 322. 零钱兑换
 * @email
 * @date 2022/6/14 10:05
 */
public class Solution322 {


    public static int coinChange(int[] coins, int amount) {

        if (amount == 0){
            return 0;
        }

        //对coins进行跑鞋，方便剪枝
        Arrays.sort(coins);

        int[] f = new int[amount+1];

        //init
        f[0] = 0;

        for (int i = 1; i < f.length; i++) {
            f[i] = Integer.MAX_VALUE;

            for (int i1 = 0; i1 < coins.length; i1++) {
                if (i >= coins[i1] && f[i-coins[i1]] != Integer.MAX_VALUE){
                    f[i] = Math.min(f[i-coins[i1]] + 1,f[i]);
                }
            }

        }

        if(f[amount] == Integer.MAX_VALUE){
            return -1;
        }


        return f[amount];
    }

    public static void main(String[] args) {
//        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange(new int[]{186,419,83,408}, 6249));
    }

}
