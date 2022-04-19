package queue.problem71;

import java.util.ArrayDeque;
import java.util.Deque;

/** 
 * @author mango
 * @date 2022/4/15 22:18
 * @version 1.0 
 * @description: TODO 
 */
public class Solution71 {

    public String simplifyPath(String path) {

        Deque<String> deque = new ArrayDeque<>();
        String[] split = path.split("/");
        for (int i = 0; i < split.length; i++) {
            if (".".equals(split[i]) || "".equals(split[i])){
                continue;
            }
            if ("..".equals(split[i])){
                deque.pollLast();
                continue;
            }
            deque.offerLast(split[i]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!deque.isEmpty()){
            stringBuilder
                    .append("/")
                    .append(deque.pollFirst());
        }
        if (stringBuilder.length() == 0){
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }

}
