package search.binarysearch.problem153;

/**
 * @author mango
 * @version 1.0
 * @description 153. 寻找旋转排序数组中的最小值
 * @email
 * @date 2022/4/14 8:28
 */
public class Solution153 {

    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int cur;

        if (nums[end] >= nums[start]){
            return nums[0];
        }

        while (start != end){
            cur = (end + 1 + start) / 2;
            if (nums[cur] > nums[0]){
                start = cur;
            }else {
                end = cur - 1;
            }
        }
        return nums[end+1];
    }

    public static void main(String[] args) {

//        int[] nums = new int[]{4,5,6,7,0,1,2};
//        int[] nums = new int[]{11,13,15,17};
        int[] nums = new int[]{3,4,5,1,2};

        Solution153 solution153 = new Solution153();
        System.out.println(solution153.findMin(nums));
    }
}
