package problem172;

/**
 * @author mango
 * @version 1.0
 * @description 阶乘后的零
 * @email
 * @date 2022/3/25 8:58
 */
public class Solution172 {


    //方法1
    private static int trailingZeroes(int n) {
        if (n < 5){
            return 0;
        }
        int result = 0;
        for (int i=5; i <= n;  i=i+5){
            for (int x = i; x % 5 == 0; x /= 5) {
                ++result;
            }
        }

        return result;
    }

    //方法2
    private static int trailingZeroes2(int n) {
        return n == 0 ? 0 : n/5 + trailingZeroes2(n/5);
    }


    //方法3
    private static int trailingZeroes3(int n) {
        if (n < 5){
            return 0;
        }
        int count = 0;
        while (n >=5 ){
            n /= 5;
            count += n;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(50246));
        System.out.println(trailingZeroes2(50246));
        System.out.println(trailingZeroes3(50246));
    }
}
