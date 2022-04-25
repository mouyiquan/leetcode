package hash.problem398;

import java.util.Random;

/**
 * @author mango
 * @version 1.0
 * @description 398. 随机数索引
 * @email
 * @date 2022/4/25 8:42
 */
public class Solution398 {

    int[] nums;
    Random random;

    public Solution398(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        int ans = 0;
        for (int i = 0, cnt = 0; i < nums.length; ++i) {
            if (nums[i] == target) {
                ++cnt; // 第 cnt 次遇到 target
                if (random.nextInt(cnt) == 0) {
                    ans = i;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(1));
        System.out.println(random.nextInt(2));
        System.out.println(random.nextInt(3));
        System.out.println(random.nextInt(4));
        System.out.println(random.nextInt(5));
        System.out.println(random.nextInt(6));
        System.out.println(random.nextInt(7));
        System.out.println(random.nextInt(8));
        System.out.println(random.nextInt(9));
        System.out.println(random.nextInt(10));
    }
}
