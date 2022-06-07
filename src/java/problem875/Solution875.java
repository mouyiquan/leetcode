package problem875;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mango
 * @version 1.0
 * @description 类似题目
     * 275. H 指数 II
     * 611. 有效三角形的个数
     * 1011. 在 D 天内送达包裹的能力
     * 1482. 制作 m 束花所需的最少天数等
 * @email
 * @date 2022/6/7 8:44
 */
public class Solution875 {

    public static int minEatingSpeed(int[] piles, int h) {


        Arrays.sort(piles);
        int max = Integer.MIN_VALUE;
        for (Integer integer : piles) {
            max = Math.max(integer,max);
        }

        int min = 0;

        if (piles.length == h){
            return max;
        }

        int middle = (max + min + 1) / 2;
        boolean flag = true;
        List<Integer> result = new ArrayList<>();

        while(flag){

            if (middle == min || middle == max){
                flag = false;
            }

            int count = 0;
            for (int pile : piles) {
                int value = pile / middle;
                count += pile % middle == 0 ? value : value + 1;
            }

            if (count <= h){
                result.add(middle);
                max = middle;
                middle = (min + middle + 1) / 2;
            }else {
                min = middle;
                middle = (max + middle + 1) / 2;
            }
        }

        int data = Integer.MAX_VALUE;
        for (Integer integer : result) {
            data = Math.min(integer,data);
        }

        return data;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{312884470}, 312884469));
    }

}
