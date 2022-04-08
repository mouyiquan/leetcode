package search.binarysearch.problem704;

/**
 * @author mango
 * @version 1.0
 * @description TODO
 * @email
 * @date 2022/4/8 10:34
 */
public class Solution704 {

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        int result = -1;

        while (start <= end){
            int mid = start + end >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        System.out.println(search(nums, 9));
    }
}
