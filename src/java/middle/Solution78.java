package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mango
 * @version 1.0
 * @description 78. 子集
 * https://leetcode.cn/problems/subsets/
 * @email
 * @date 2022/7/25 18:19
 */
public class Solution78 {

    List<List<Integer>> data = new ArrayList<>();

    /**
     * 递归
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        data.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> subList = new ArrayList<>();
            for (List<Integer> datum : data) {
                List<Integer> list = new ArrayList(datum);
                list.add(num);
                subList.add(list);
            }
            data.addAll(subList);
        }

        return data;
    }
}
