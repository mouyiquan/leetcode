package problem380;

import java.util.*;

/**
 * @author mango
 * @version 1.0
 * @description 380. O(1) 时间插入、删除和获取随机元素
 * @email
 * @date 2022/4/13 8:57
 */
public class Solution380 {

    List<Integer> list;
    Map<Integer, Integer> map;
    Random random;

    public Solution380() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)){
            return false;
        }
        //获取待删除元素的下标
        Integer index = map.get(val);
        int size = list.size();
        //获取最后一个元素的值
        Integer last = list.get(size - 1);

        /**
         * 将list的最后一个元素移动到待删除的元素的位置，否则在删除的时候会造成数组内值的前置操作，导致时间复杂度为O(n)
         */
        list.set(index,last);
        map.put(last, index);

        //删除元素
        map.remove(val);
        list.remove(size - 1);
        return true;
    }

    public int getRandom() {
        int index = random.nextInt(list.size());

        return list.get(index);
    }

    public static void main(String[] args) {
        Solution380 solution380 = new Solution380();

        solution380.insert(0);
        solution380.insert(1);
        solution380.remove(0);
        solution380.insert(2);
        solution380.remove(1);
        System.out.println(solution380.getRandom());


    }
}
