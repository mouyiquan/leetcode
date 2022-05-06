package dp.problem1713;

import java.util.*;

/**
 * @author mango
 * @version 1.0
 * @description TODO
 * @email
 * @date 2022/5/6 8:55
 */
public class Solution1713 {


    //动态规划 + 贪心 + 二分
    public int minOperations(int[] target, int[] arr) {
        int n = target.length, m = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        //将target的下标保存下来
        for (int i = 0; i < n; i++) {
            map.put(target[i], i);
        }

        //求交集，将arr存在的元素全部存入list
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (map.containsKey(arr[i])) {
                list.add(map.get(arr[i]));
            }
        }

        int len = list.size();
        int max = 0;
        int[] f = new int[len + 1], g = new int[len + 1];
        Arrays.fill(g, Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            int t = list.get(i);
            int l = 0, r = len;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (g[mid] < t) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            int clen = r + 1;
            f[i] = clen;
            g[clen] = Math.min(g[clen], t);
            max = Math.max(max, f[i]);
        }
        return n - max;
    }
}
