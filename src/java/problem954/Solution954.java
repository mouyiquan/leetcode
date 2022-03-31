package problem954;

import java.util.*;

/**
 * @author mango
 * @version 1.0
 * @description 954. 二倍数对数组
 * @email
 * @date 2022/4/1 9:55
 */
public class Solution954 {


    /**
     * 方法1，优先级队列，由于做了排序，还做了remove，所以非常的慢
     * 耗时：729ms
     * @param arr
     * @return
     */
    public static boolean canReorderDoubled(int[] arr) {
        boolean result = true;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(Math::abs));
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        while (!queue.isEmpty() && result){
            result = queue.remove(2 * queue.poll());
        }
        return result;
    }

    /**
     * 2.Map + 排序
     * 耗时：23ms
     * @param arr
     * @return
     */
    public static boolean canReorderDoubled2(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int x : arr) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        if (cnt.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }

        List<Integer> vals = new ArrayList<Integer>();
        for (int x : cnt.keySet()) {
            vals.add(x);
        }
        Collections.sort(vals, (a, b) -> Math.abs(a) - Math.abs(b));

        for (int x : vals) {
            if (cnt.getOrDefault(2 * x, 0) < cnt.get(x)) {
                return false;
            }
            cnt.put(2 * x, cnt.getOrDefault(2 * x, 0) - cnt.get(x));
        }
        return true;
    }



    public static void main(String[] args) {
        PriorityQueue<Integer> queue1= new PriorityQueue<>(Comparator.comparingInt(a -> a));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(Math::abs));
        queue.add(1);
        queue.add(-1);
        queue.add(2);
        queue.add(0);
        queue.add(-2);
        queue.add(0);
        boolean remove = true;
        while (!queue.isEmpty() && remove){
            Integer poll = queue.poll();
            System.out.println(poll);
            remove = queue.remove(2 * poll);
        }
//        if (!remove){
            System.out.println(remove);
//        }
    }
}
