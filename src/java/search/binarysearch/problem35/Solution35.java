package search.binarysearch.problem35;

/**
 * @author mango
 * @version 1.0
 * @description TODO
 * @email
 * @date 2022/4/8 11:09
 */
public class Solution35 {

    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;
        int mid = 0;

        while (l <= r){
            mid = l + (r - l) / 2;
            if (nums[mid] == target){
                r = mid - 1;
                break;
            }
            if (nums[mid] < target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }

        return r+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        System.out.println(searchInsert(nums, 7));
    }
}
