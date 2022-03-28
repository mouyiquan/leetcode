package problem693;

/**
 * @author mango
 * @version 1.0
 * @description TODO
 * @email
 * @date 2022/3/28 8:42
 */
public class Solution693 {

    private static boolean hasAlternatingBits(int n) {
        boolean result = true;
        while(n!=0 && result){
//            System.out.println(n);
//            System.out.println(n&1);
//            System.out.println(n&2);
            result = (n & 1) != (n & 2) >> 1;
            n = n >> 1;
//            System.out.println(n);
        }
        return result;
    }

    public static boolean hasAlternatingBits2(int n) {
        String result =  Integer.toString(n,2);
        if(result.contains("00") || result.contains("11")){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(4));
        System.out.println(hasAlternatingBits(5));
        System.out.println(hasAlternatingBits(7));
        System.out.println(hasAlternatingBits(11));
    }
}
