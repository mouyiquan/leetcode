package offer2;


/**
 *  剑指 Offer II 091. 粉刷房子
 * https://leetcode.cn/problems/JEj789/
 */
public class Solution91 {


    //
    public int minCost(int[][] costs) {


        for (int i = 1; i < costs.length; i++) {
            costs[i][0] = Math.min(costs[i-1][1]+costs[i][0] , costs[i-1][2] + +costs[i][0]) ;
            costs[i][1] = Math.min(costs[i-1][0]+costs[i][1] , costs[i-1][2] + +costs[i][1]) ;
            costs[i][2] = Math.min(costs[i-1][0]+costs[i][2] , costs[i-1][1] + +costs[i][2]) ;
        }

        return Math.min(Math.min(costs[costs.length-1][0],costs[costs.length-1][1]),costs[costs.length-1][2]);
    }

}
