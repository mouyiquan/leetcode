package problem429;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author mango
 * @version 1.0
 * @description 429. N 叉树的层序遍历
 * @email
 * @date 2022/4/8 8:38
 */
public class Solution429 {


    //经典bfs
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null){
            return new ArrayList<>();
        }

        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(root);

        List<List<Integer>> result = new ArrayList<>();

        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> res = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node poll = queue.pollFirst();
                List<Node> children = poll.getChildren();
                if (children!=null){
                    for (Node child : children) {
                       queue.addLast(child);
                    }
                    res.add(poll.getVal());
                }
            }
            result.add(res);
        }

        return result;
    }


}
