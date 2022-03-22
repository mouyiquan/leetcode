package problem2038;
/**
 * @author mango
 * @version 1.0
 * @description   2038. 如果相邻两个颜色均相同则删除当前颜色
 * @email
 * @date 2022/3/22 10:58
 */
public class Solution2038 {

    public static boolean winnerOfGame(String colors) {

        char aChar = 'A';
        char bChar = 'B';

        int a = 0;
        int b = 0;
        for (int i = 1; i < colors.length()-1; i++) {
            if (aChar == colors.charAt(i) && aChar == colors.charAt(i-1) && aChar == colors.charAt(i+1)){
                a++;
            }
            if (bChar == colors.charAt(i) && bChar == colors.charAt(i-1) && bChar == colors.charAt(i+1)){
                b++;
            }
        }
        if ( a > b){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("AAABABB".charAt(0));
        System.out.println("AAABABB".charAt(1));
        System.out.println("AAABABB".charAt(2));
        System.out.println("AAABABB".charAt(6));
        System.out.println("AAABABB".length());
        System.out.println(winnerOfGame("AAABABB"));
    }
}
