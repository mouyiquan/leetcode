package offer;

/**
 * @author mango
 * @version 1.0
 * @description 剑指 Offer 44. 数字序列中某一位的数字
 * https://leetcode.cn/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 * @email
 * @date 2022/6/30 17:54
 */
public class Offer44 {


    /**
     * 0~9 : 10个字符
     * 10~99 : 2*9*10个字符
     * 100~999 : 3*9*100个字符
     * 1000~9999 : 4*9*1000个字符
     * ********
     * 9999前面的字符数为 “ 9 + （99-10+1）*2 + （999-100+1）* 3 + （9999-1000+1）* 4 ” 个字符
     *
     * @param n
     * @return
     */
    public static int findNthDigit(int n) {
        int d = 1;
        int count = 9;

        while (n > d * count){
            n-= d*count;
            d++;
            count *=10;
        }

        //因为是从0开始的
        int index = n - 1;
        int start = (int) Math.pow(10,d-1);

        //确定是哪个数
        int num =  start + index/d;
        int digitIndex = index%d;

        int digit = (num / (int)(Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(15));
    }
}
