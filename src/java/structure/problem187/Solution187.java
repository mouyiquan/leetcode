package structure.problem187;

import java.util.*;

/**
 * @author mango
 * @version 1.0
 * @description 187. 重复的DNA序列
 * @email
 * @date 2022/6/15 11:09
 */
public class Solution187 {

    public static List<String> findRepeatedDnaSequences(String s) {

            ArrayList<String> list = new ArrayList<>();
            if (s.length() <= 10){
                return list;
            }

            Map<String, Integer> map = new HashMap<>();
//            map.put(s.substring(0,10),1);

            for (int i = 0; i <= s.length()-10; i++) {
                String substring = s.substring(i, i + 10);
                map.put(substring, map.getOrDefault(substring,0)+1);
            }

            for (String str : map.keySet()){
                if (map.get(str) > 1){
                    list.add(str);
                }
            }

            return list;
    }


    //超时
    public static List<String> findRepeatedDnaSequences2(String s) {

        if (s.length() <= 10){
            return new ArrayList<>();
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length()-10; i++) {
            String substring = s.substring(i, i + 10);
            int i1 = s.indexOf(substring);
            int i2 = s.indexOf(substring, i1+1);
            if (i1 != -1 && i2 != -1 && i2  != i1){
                set.add(substring);
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences2("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
