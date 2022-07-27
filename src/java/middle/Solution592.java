package middle;

/**
 * @author mango
 * @version 1.0
 * @description 592. 分数加减运算
 * https://leetcode.cn/problems/fraction-addition-and-subtraction/
 * @email
 * @date 2022/7/27 8:40
 */
public class Solution592 {

    public static String fractionAddition(String expression) {
        long max = 1;
        long sum = 0;
        String[] split = expression.split("[+|-]");

        if (expression.startsWith("-")){
            int[] fenzi = new int[split.length-1];
            int[] fenmu = new int[split.length-1];
            //分子找最大公倍数
            for (int i = 1; i < split.length; i++) {
                String[] split1 = split[i].split("/");
                int tmp = Integer.parseInt(split1[1]);
                fenzi[i-1] = Integer.parseInt(split1[0]);
                fenmu[i-1] = tmp;
                if (max % tmp != 0){
                    max *= tmp;
                }
            }

            int index = 0;
            for (int i = 0; i < fenzi.length; i++) {
                if (expression.charAt(index) == '-'){
                    sum -= fenzi[i] * (max / fenmu[i]);
                }else {
                    sum += fenzi[i] * (max / fenmu[i]);
                }

                int i1 = expression.indexOf("+", index+1);
                int i2 = expression.indexOf("-", index + 1);
                if (i1 == -1){
                    index = i2;
                }else if (i2 == -1){
                    index = i1;
                }else {
                    index = Integer.min(i1,i2);
                }
            }
        }else {
            Integer[] fenzi = new Integer[split.length];
            Integer[] fenmu = new Integer[split.length];

            //分子找最大公倍数
            for (int i = 0; i < split.length; i++) {
                String[] split1 = split[i].split("/");
                int tmp = Integer.parseInt(split1[1]);
                fenzi[i] = Integer.parseInt(split1[0]);
                fenmu[i] = tmp;
                if (max % tmp != 0){
                    max *= tmp;
                }
            }
            int index = 0;
            sum = fenzi[0] * (max / fenmu[0]);
            for (int i = 1; i < fenzi.length; i++) {
                int i1 = expression.indexOf("+", index+1);
                int i2 = expression.indexOf("-", index + 1);
                if (i1 == -1){
                    index = i2;
                }else if (i2 == -1){
                    index = i1;
                }else {
                    index = Integer.min(i1,i2);
                }
                if (expression.charAt(index) == '-'){
                    sum -= fenzi[i] * (max / fenmu[i]);
                }else {
                    sum += fenzi[i] * (max / fenmu[i]);
                }
            }
        }
        if (sum == 0){
            return "0/1";
        }

        long division = division(max, sum);
        if (max/division < 0 ){
            return (-sum/division )+ "/" + (-max/division);
        }
        return sum/division + "/" + max/division;
    }

    //辗转相除法实现
    private static long division(long a, long b){
        long temp;
        if(a < b){
            temp = a;
            a = b;
            b = temp;

        }
        while(a%b != 0){
            temp = a%b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(fractionAddition("-4/7-3/4+2/3"));
//        System.out.println(fractionAddition("-1/2+1/2+1/3"));
//        System.out.println(fractionAddition("1/3-1/2"));
    }
}
