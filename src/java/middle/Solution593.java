package middle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mango
 * @version 1.0
 * @description 593. 有效的正方形
 * https://leetcode.cn/problems/valid-square/
 * @email
 * @date 2022/7/29 9:08
 */
public class Solution593 {

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        int[][] tmp = new int[4][2];

        tmp[0] = p1;
        tmp[1] = p2;
        tmp[2] = p3;
        tmp[3] = p4;

        Arrays.sort(tmp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]){
                    return 1;
                }
                if (o1[0] == o2[0] && o1[1] > o2[1]){
                    return 1;
                }

                return -1;
            }
        });

        //第一个和第三个点的距离应该等于第二个点到第四个点的距离
        String distance = distance(tmp[0], tmp[3]);
        String distance1 = distance(tmp[1], tmp[2]);
        if (!distance.equals(distance1)){
            return false;
        }
        //第一个点到第二个和第三个的距离应该相等
        if (!distance(tmp[0],tmp[1]) .equals( distance(tmp[0],tmp[2]))){
            return false;
        }

        //如果四个点有重复的则为false
        Set<String> set = new HashSet<>();
        set.add(p1[0] + "" + p1[1]);
        set.add(p2[0] + "" + p2[1]);
        set.add(p3[0] + "" + p3[1]);
        set.add(p4[0] + "" + p4[1]);

        if (set.size() < 4){
            return false;
        }
        return true;
    }

    public static String distance(int[] p1, int[] p2){
        int sum = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        return "" + Math.abs(sum);
    }

    public static void main(String[] args) {
//        System.out.println(validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1}));
        System.out.println(validSquare(new int[]{1134,-2539}, new int[]{492,-1255}, new int[]{-792,-1897}, new int[]{-150,-3181}));
    }
}
