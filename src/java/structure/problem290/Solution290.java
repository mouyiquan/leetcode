package structure.problem290;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author mango
 * @version 1.0
 * @description 290.单词规律
 * @email
 * @date 2022/6/13 9:06
 */
public class Solution290 {
    public boolean wordPattern(String pattern, String s) {

        String[] split = s.split(" ");

        if (pattern.length() != split.length){
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < split.length; i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)){
                String s1 = map.get(c);
                if (!s1.equals(split[i])){
                    return false;
                }
            }else if (set.contains(split[i])){
                return false;
            }else {
                map.put(c,split[i]);
                set.add(split[i]);
            }

        }


        return true;
    }
}
