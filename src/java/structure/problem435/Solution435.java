package structure.problem435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author mango
 * @version 1.0
 * @description 435. 无重叠区间
 * @email
 * @date 2022/6/10 8:17
 */
public class Solution435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));

        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }

}
