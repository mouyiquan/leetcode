package problem1606;

import java.util.*;

/**
 * @author mango
 * @version 1.0
 * @description 1606. 找到处理最多请求的服务器
 *
 * @email
 * @date 2022/3/30 8:30
 */
public class Solution1606 {



    //1.暴力求解
    public static List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        //正在运行的数组
        List<Integer> runtime = new ArrayList<>(k);
        List<Integer> finish = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            runtime.add(i, 0);
            finish.add(i, 0);
        }

        //扫描一遍发现没有空闲的
        int n = 0;

        //逻辑运算
        for (int i = 0; i < arrival.length; i++) {
            n=0;
            for (int j = i; j < i+k; j++) {
                int m = j % k;
                if (arrival[i] >= runtime.get(m)){
                    runtime.set(m,arrival[i] + load[i]);
                    finish.set(m, finish.get(m) + 1);
                    break;
                }
                n++;
            }
            if (n == k){
                break;
            }
        }

        int m = 1;
        List<Integer> result = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            Integer value = finish.get(i);
            if (value < m){
                continue;
            }
            if (value == m){
                result.add(i);
                continue;
            }
            m = value;
            result = new ArrayList<>();
            result.add(i);
        }


        return result;
    }

    //2.模拟 + 有序集合 + 优先队列
    public static List<Integer> busiestServers2(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<Integer>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        PriorityQueue<int[]> busy = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int[] requests = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                available.add(busy.poll()[1]);
            }
            if (available.isEmpty()) {
                continue;
            }
            Integer p = available.ceiling(i % k);
            if (p == null) {
                p = available.first();
            }
            requests[p]++;
            busy.offer(new int[]{arrival[i] + load[i], p});
            available.remove(p);
        }
        int maxRequest = Arrays.stream(requests).max().getAsInt();
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            if (requests[i] == maxRequest) {
                ret.add(i);
            }
        }
        return ret;
    }


    //3 模拟 + 双优先队列
    public static List<Integer> busiestServers3(int k, int[] arrival, int[] load) {
        PriorityQueue<Integer> available = new PriorityQueue<Integer>((a, b) -> a - b);
        for (int i = 0; i < k; i++) {
            available.offer(i);
        }
        PriorityQueue<int[]> busy = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int[] requests = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                int id = busy.peek()[1];
                busy.poll();
                available.offer(i + ((id - i) % k + k) % k); // 保证得到的是一个不小于 i 的且与 id 同余的数
            }
            if (available.isEmpty()) {
                continue;
            }
            int server = available.poll() % k;
            requests[server]++;
            busy.offer(new int[]{arrival[i] + load[i], server});
        }
        int maxRequest = Arrays.stream(requests).max().getAsInt();
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            if (requests[i] == maxRequest) {
                ret.add(i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int k = 2;
        int[] arrival = new int[]{2,3,4,8};
        int[] load = new int[]{3,2,4,3};
        List<Integer> list = busiestServers3(k, arrival, load);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
