package problem310;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mango
 * @version 1.0
 * @description 310. 最小高度树
 * @email
 * @date 2022/4/6 15:20
 */
public class Solution310 {

    /**
     * 方法1  bfs+邻接链表
     * @param n
     * @param edges
     * @return
     */
    private static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        //1.如果只有一个节点，那么他就是最小高度树
        if (n==1){
            result.add(0);
            return result;
        }

        //2.建立每个节点的叶子节点数
        //默认每个节点为0
        int[] degree = new int[n];

        //3.建立图关系，在每个节点的list中存储相连节点
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            degree[edge[0]]++;
            degree[edge[1]]++;
            //添加相连节点
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        //建立队列
        Queue<Integer> queue = new LinkedList<>();
        //把所有只有一个相连节点的节点本身加入队列
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1){
                queue.offer(i);
            }
        }

        //循环判空
        while (!queue.isEmpty()){
            //每次需要重新生成对象，因为当前只有一个相连节点的节点发生改变
            result = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                //假如当前剩余节点就是我们要的
                result.add(poll);
                /**
                 * 获取当前节点的邻接节点，当然节点本身只有一个相连节点，但是相连节点的相连节点可能不止一个
                 */
                List<Integer> list = map.get(poll);
                /*这里就是经典的bfs了，把当前节点的相邻接点都拿出来，
                 * 把它们的出度都减1，因为当前节点已经不存在了，所以，
                 * 它的相邻节点们就有可能变成叶子节点
                 */
                for (int neighbor : list) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        /*如果是叶子节点我们就入队*/
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = new int[][]{{1,0},{1,2},{1,3}};
        List<Integer> minHeightTrees = findMinHeightTrees(n, edges);
        if(minHeightTrees!=null){
            for (Integer minHeightTree : minHeightTrees) {
                System.out.println(minHeightTree);
            }
        }
    }
}
