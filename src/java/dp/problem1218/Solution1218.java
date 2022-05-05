package dp.problem1218;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mango
 * @version 1.0
 * @description 1218. 最长定差子序列
 * @email
 * @date 2022/5/5 9:13
 */
public class Solution1218 {


    /**
     *  一维dp问题
     * @param arr
     * @param difference
     * @return
     */
    public int longestSubsequence(int[] arr, int difference) {

        int ans = 1;
        Map<Integer, Integer> dp = new HashMap<>();
        for (int i : arr) {
            Integer orDefault = dp.getOrDefault((i - difference), 1);
            dp.put(i, orDefault + 1);
            ans = Math.max(ans , orDefault);
        }
        return ans;
    }
}
