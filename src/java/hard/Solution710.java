package hard;

import java.util.*;

/**
 * 710. 黑名单中的随机数
 * https://leetcode.cn/problems/random-pick-with-blacklist/
 */
public class Solution710 {

    int n;
    Map<Integer, Integer> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();

    Random random = new Random(n);

    //双指针超时
    public Solution710(int n, int[] blacklist, int leftRight) {
        this.n = n;
        for (int i = 0; i < blacklist.length; i++) {
            set.add(blacklist[i]);
        }

        int left= 0 ;
        int right= n-1;
        for ( ; left < n - blacklist.length; left++) {
            if (set.contains(left)) {
                while (set.contains(right)) {
                    right--;
                }
                map.put(left, right);
                right--;
            }
        }
    }

    //
    public Solution710(int n, int[] blacklist) {
        this.n = n;

        int i1 = n - blacklist.length - 1;
        ArrayList<Integer> objects = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < blacklist.length; i++) {
            if (blacklist[i] <= i1){
                objects.add(blacklist[i]);
                j++;
            }
            set.add(blacklist[i]);
        }
        int k = j;
        for (int i = n-1; i >= n - blacklist.length && k > 0; i--) {
            if (set.contains(i)){
                continue;
            }
            map.put(objects.get(k-1),i);
            k--;
        }
    }

    public int pick() {
        int i = random.nextInt(n - set.size());
        if (map.containsKey(i)){
            return map.get(i);
        }
        return i;
    }

    public static void main(String[] args) {

        Solution710 solution710 = new Solution710(4, new int[]{0,3});
        for (int i = 0; i < 30; i++) {
            System.out.println(solution710.pick());
        }

    }
}
