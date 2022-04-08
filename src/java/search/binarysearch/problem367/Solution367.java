package search.binarysearch.problem367;

/**
 * @author mango
 * @version 1.0
 * @description 367. 有效的完全平方数
 * @email
 * @date 2022/4/8 12:31
 */
public class Solution367 {


    //方法1 二分
    public static boolean isPerfectSquare(int num) {

        long l = 0;
        long r = num;

        while (l <= r){
            long mid = (r+l + 1)/2;
            long data = mid * mid;
            if (data == num){
                return true;
            }else if (data > num){
                r = mid-1;
            }else {
                l = mid+1;
            }
        }

        return false;
    }

    //方法2 数学
    //num=n^2=1+3+5+...+(2∗n−1)
    public static boolean isPerfectSquare2(int num) {
        int x = 1;
        while (num > 0) {
            num -= x;
            x += 2;
        }
        return num == 0;
    }



    public static void main(String[] args) {
        System.out.println(isPerfectSquare(2147483647));
    }
}
