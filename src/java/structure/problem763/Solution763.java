package structure.problem763;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author mango
 * @version 1.0
 * @description 763. 划分字母区间
 * @email
 * @date 2022/6/13 9:33
 */
public class Solution763 {

    /**
     * 字符串 S 由小写字母组成。
     * 我们要把这个字符串划分为尽可能多的片段，
     * 同一字母最多出现在一个片段中。
     * 返回一个表示每个字符串片段的长度的列表。
     *
     * @param s
     * @return
     */
    public static List<Integer> partitionLabels(String s) {

        ArrayList<Integer> objects = new ArrayList<>();

        if (s.length() == 1){
            objects.add(1);
            return objects;
        }

        //将24个字母第一次和最后一次出现的位置记录下来
        Map<Character, int[]> map = new HashMap<>();

        //统计到map中
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                int[] ints = map.get(c);
                ints[1] = i;
                map.put(c,ints);
            }else {
                int[] ints = new int[2];
                ints[0] = i;
                ints[1] = i;
                map.put(c,ints);
            }
        }

        //对map的数据进行拆分得到字母的数字区间


        List<int[]> list = new ArrayList<>(map.values().size());
        Set<Character> characters = map.keySet();
        for (Character character : characters) {
            list.add(map.get(character));
        }

        List<int[]> collect = list.stream().sorted(Comparator.comparingInt(o -> o[0])).collect(Collectors.toList());

        if (collect.size() == 1){
            objects.add(collect.get(0)[1] + 1);
            return objects;
        }else {
            objects.add(collect.get(0)[1] + 1);
        }

        int n = 1;

        for (int i = 1; i < collect.size(); i++) {
            int[] a = collect.get(i);
            int[] b = collect.get(i-n);
            if (a[0] <= b[1]){


                if (a[1] <= b[1]){
                    n++;
                    continue;
                }else {
                    n=1;
                }

                Integer integer = objects.get(objects.size() - 1);
                integer = integer + a[1]  - b[1];
                objects.set(objects.size() - 1,integer);


            }else {
                n =1;
                objects.add(a[1] - a[0] + 1);
            }
        }

        return objects;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

}
