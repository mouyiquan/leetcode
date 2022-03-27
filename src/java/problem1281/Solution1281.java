package problem1281;

public class Solution1281 {

    public static int subtractProductAndSum(int n) {
        if (n == 0){
            return 0;
        }
        String str = n + "";
        int sum1 = 0;
        int sum2 = 1;

        for (int i = 0; i < str.length(); i++) {
            Integer a = Integer.parseInt(str.charAt(i) + "");
            sum1 += a;
            sum2 *= a;
        }

        return sum2 - sum1 ;
    }

    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
    }
}
