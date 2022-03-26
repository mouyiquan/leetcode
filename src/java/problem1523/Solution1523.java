package problem1523;

public class Solution1523 {
    public static int countOdds(int low, int high) {
        return pre(high) - pre(low - 1);
    }

    public static int pre(int x) {
        return (x + 1) >> 1;
    }

    //常规方法
    public static int countOdds2(int low, int high) {
        return (high % 2 == 0 ? high / 2 : high / 2 +1) - low / 2;
    }

    public static void main(String[] args) {
        System.out.println(countOdds(3, 100));
        System.out.println(countOdds2(3, 100));
    }
}
