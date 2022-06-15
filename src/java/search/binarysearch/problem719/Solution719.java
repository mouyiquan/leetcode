package search.binarysearch.problem719;

import java.util.*;

/**
 * @author mango
 * @version 1.0
 * @description Level：HARD 719. 找出第 K 小的数对距离
 * @email
 * @date 2022/6/15 8:51
 */
public class Solution719 {



    //超出内存限制（空间换时间失败）
    public static int smallestDistancePair(int[] nums, int k) {

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < nums.length-1; i++) {
            for (int i1 = i+1; i1 < nums.length; i1++) {
                int[] ints = new int[2];
                ints[0] = nums[i];
                ints[1] = nums[i1];
                list.add(ints);
            }
        }

        //排序
        list.sort(Comparator.comparingInt(o -> Math.abs(o[0] - o[1])));

        //二分查找
        int[] ints = list.get(k - 1);

        return Math.abs(ints[0] - ints[1]);
    }

    //直接对nums排序,超出时间限制
    public static int smallestDistancePair2(int[] nums, int k) {


//        //排序
//        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length-1; i++) {
            for (int i1 = i+1; i1 < nums.length; i1++) {
                Integer i2 = Math.abs(nums[i] - nums[i1]);
                map.put(i2, map.getOrDefault(i2,0) + 1);
            }
        }

        Object[] objects = map.keySet().toArray();
        Arrays.sort(objects);

        int num = 0 ;
        for (Object object : objects) {
            num += map.get(object);
            if (k <= num){
                return Integer.parseInt(object.toString());
            }
        }

        return 0;
    }


    //官方 排序 + 二分查找 + 双指针
    public static int smallestDistancePair3(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n - 1] - nums[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 0, j = 0; j < n; j++) {
                while (nums[j] - nums[i] > mid) {
                    i++;
                }
                cnt += j - i;
            }
            if (cnt >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    public static void main(String[] args) {
        System.out.println(smallestDistancePair2(new int[]{1,6,1}, 3));

    }
}
