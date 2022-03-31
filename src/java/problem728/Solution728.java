package problem728;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mango
 * @version 1.0
 * @type simple
 * @description 728. 自除数
 * @email
 * @date 2022/3/31 9:43
 */
public class Solution728 {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean isSelfDividing(int num) {
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }

}
