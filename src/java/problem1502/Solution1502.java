package problem1502;

import java.util.Arrays;

/**
 * @author mango
 * @version 1.0
 * @description 等差数列
 * @email
 * @date 2022/3/28 9:55
 */
public class Solution1502 {

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length - 1; ++i) {
            if (arr[i] * 2 != arr[i - 1] + arr[i + 1]) {
                return false;
            }
        }
        return true;
    }


}
