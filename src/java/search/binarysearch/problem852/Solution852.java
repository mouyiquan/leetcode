package search.binarysearch.problem852;

/**
 * @author mango
 * @version 1.0
 * @description 852. 山脉数组的峰顶索引
 * @email
 * @date 2022/4/8 12:19
 */
public class Solution852 {

    /**
     * 符合下列属性的数组 arr 称为 山脉数组 ：
     * arr.length >= 3
     * 存在 i（0 < i < arr.length - 1）使得：
     * arr[0] < arr[1] < ... arr[i-1] < arr[i]
     * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
     * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
     *
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l<=r){
            int mid = (r + l + 1) / 2;
            if (arr[mid-1] > arr[mid]){
                r = mid-1;
            }else {
                l = mid+1;
            }
        }


        return r;
    }

}
