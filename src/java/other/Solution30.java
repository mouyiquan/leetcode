package other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mango
 * @version 1.0
 * @description 30. 串联所有单词的子串
 * https://leetcode.cn/problems/substring-with-concatenation-of-all-words/
 * @email
 * @date 2022/6/23 8:38
 */
public class Solution30 {

    //滑动窗口
    public static List<Integer> findSubstring(String s, String[] words) {
        int wordLength = words[0].length();
        int allLength = wordLength * words.length;

        if (s.length() < allLength){
            return new ArrayList<>();
        }
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word,0) + 1);
        }
        List<Integer> result = new ArrayList<>();

        int start = 0;
        while (start + allLength <= s.length()){
            int left = start;
            Map<String, Integer> tmp = new HashMap(map);

            boolean flag = true;
            for (int i = 1; i <= words.length; i++) {
                String substring = s.substring(left, left + wordLength);
                if (tmp.containsKey(substring)){
                    Integer integer = tmp.get(substring);
                    if (integer == 1){
                        tmp.remove(substring);
                    }else {
                        tmp.put(substring,integer-1);
                    }
                    left += wordLength;
                }else {
                    flag = false;
                    break;
                }
            }

            if (flag){
                result.add(start);
            }
            start++;
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> barfoofoobarthefoobarman = findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake",
                new String[]{"fooo","barr","wing","ding","wing"});

        for (Integer integer : barfoofoobarthefoobarman) {
            System.out.println(integer);
        }
    }
}
