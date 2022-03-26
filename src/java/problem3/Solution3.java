package problem3;

public class Solution3 {

    public static int lengthOfLongestSubstring(String s) {

        if (s.length() == 0){
            return 0;
        }

        int result = 1;
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int j = str.indexOf(String.valueOf(s.charAt(i)));
            if (j == -1) {
                str.append(s.charAt(i));
                if (str.length() > result){
                    result = str.length();
                }
                continue;
            }
            System.out.print(str);
            str.delete(0,j+1).append(s.charAt(i));
            System.out.println("----" + str);
        }

        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder("asbdsdwa");

        System.out.println(stringBuilder.indexOf("n"));

        System.out.println(stringBuilder.indexOf("a"));


        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
