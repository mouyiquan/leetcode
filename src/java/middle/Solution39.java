package middle;

import java.util.*;

/**
 * @author mango
 * @version 1.0
 * @description 39. 组合总和
 * https://leetcode.cn/problems/combination-sum/
 * @email
 * @date 2022/7/20 11:25
 */
public class Solution39 {

    List<List<Integer>> data = new ArrayList();
    int[] arr;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        arr = candidates;

        for (int i = 0; i < candidates.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(candidates[i]);
            combinationSum2(list, i,target - candidates[i]);
        }

        return data;
    }

    public void combinationSum2(List<Integer> list, int index,int remainCount) {

        if (remainCount == 0){
            data.add(list);
        }
        if (remainCount < 0 ){
            return;
        }

        for (int i = index; i < arr.length; i++) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(arr[i]);
            combinationSum2(newList, i,remainCount - arr[i]);
        }

    }
}
