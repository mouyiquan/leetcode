package palindrome_number.problem479;


public class Solution479 {

    //99*99 = [9801];
    //999*999 = 998001;
    //9999*9999 = 99980001;
    //99999*99999 = 99999800001;
    public int largestPalindrome(int n) {
        if(n == 1){
            return 9;
        }
        //回文数替换字符
        StringBuilder replaceStr = new StringBuilder();
        replaceStr.append("77");
        //乘积最大的数
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n-1; i++) {
            sb.append("9");
            replaceStr.append("9");
        }
        sb.append("8");
        for (int i = 0; i < n-1; i++) {
            sb.append("0");
        }
        sb.append("1");

//        System.out.println(replaceStr.toString());
        //最大的回文数
        StringBuilder maxPadlindromNumber = sb.replace(n-1, 2 * n, replaceStr.toString());
//        System.out.println(maxPadlindromNumber.toString());

        int ans = 0;
        //取模运算
        for (int i = 0; i < maxPadlindromNumber.length(); i++) {
            ans = (ans*10+ maxPadlindromNumber.charAt(i) - '0') % 1337;
        }
        return  ans;
    }

    public static void main(String[] args) {
        Solution479 solution479 = new Solution479();
        System.out.println(solution479.largestPalindrome(2));
        System.out.println(solution479.largestPalindrome(3));
        System.out.println(solution479.largestPalindrome(4));
    }
}
