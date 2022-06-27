package offer;

/**
 * @author mango
 * @version 1.0
 * @description 剑指 Offer 16. 数值的整数次方
 * https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 * @email
 * @date 2022/6/27 9:19
 */
public class Offer16 {

    public double myPow(double x, int n) {
        int N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    //快速冥
    public double quickMul(double x, int N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if ((N & 1 )== 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }

}
