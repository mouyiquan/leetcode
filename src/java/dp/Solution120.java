package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mango
 * @version 1.0
 * @description 120. 三角形最小路径和
 * https://leetcode.cn/problems/triangle/
 * @email
 * @date 2022/7/4 9:17
 */
public class Solution120 {
    public static int minimumTotal(List<List<Integer>> triangle) {

        //总行数
        int m = triangle.size();
        int[] lastLine = new int[m];
        int[] thisLine = new int[m];
        lastLine[0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0){
                    thisLine[0] = lastLine[0] + triangle.get(i).get(j);;
                    continue;
                }
                if (i == j){
                    thisLine[j] = lastLine[j-1] + triangle.get(i).get(j);
                }else {
                    thisLine[j] = Math.min(lastLine[j],lastLine[j-1]) + triangle.get(i).get(j);
                }
            }
            lastLine = Arrays.copyOfRange(thisLine,0,i+1);
        }

        int min = Integer.MAX_VALUE;
        for (int i : lastLine) {
            min = Math.min(i,min);
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> integers = new ArrayList<>();
        ArrayList<Integer> integer2 = new ArrayList<>();
        integer2.add(2);
        ArrayList<Integer> integer3 = new ArrayList<>();
        integer3.add(3);
        integer3.add(4);
        ArrayList<Integer> integer4 = new ArrayList<>();
        integer4.add(6);
        integer4.add(5);
        integer4.add(7);
        ArrayList<Integer> integer5 = new ArrayList<>();
        integer5.add(4);
        integer5.add(1);
        integer5.add(8);
        integer5.add(3);
        integers.add(integer2);
        integers.add(integer3);
        integers.add(integer4);
        integers.add(integer5);
        System.out.println(minimumTotal(integers));
    }
}
