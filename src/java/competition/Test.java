package competition;

import java.util.*;

public class Test {


    public static int longestPalindrome(String s) {

        int result = 1;
        Map<Character,Integer> map = new HashMap<>();
        for (int left = 0; left < s.length(); left++) {
            map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)+1);
        }
        Set<Character> characters = map.keySet();

        for (Character character:characters){
            Integer integer = map.get(character);
            if (integer > 1){
                result+= integer/2;
            }
        }
        return Math.min(result,s.length());
    }

    public static void main(String[] args) {

//        System.out.println(new StringBuilder("ab").subSequence(1,-1));
        System.out.println(longestPalindrome("abccccdd"));
    }
}
