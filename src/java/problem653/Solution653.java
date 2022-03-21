package problem653;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author mango
 * @version 1.0
 * @description 两数之和 IV - 输入 BST
 * @email
 * @date 2022/3/21 10:44
 */
public class Solution653 {

    private static Set<Integer> set = new HashSet<>();

    //深度优先
    private static boolean findTarget(TreeNode root, Integer k) {

        if (root == null){
            return false;
        }
        if (set.contains(k - root.getVal())){
            return true;
        }
        set.add(root.getVal());
        return findTarget(root.getLeft(),k) || findTarget(root.getRight(),k);

    }


    //广度优先
    private static boolean findTarget2(TreeNode root, Integer k) {

        if (root == null){
            return false;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (set.contains(k - poll.getVal())){
                return true;
            }
            set.add(poll.getVal());
            if (poll.getLeft()!=null){
                queue.offer(poll.getLeft());
            }
            if (poll.getRight()!=null){
                queue.offer(poll.getRight());
            }
        }


        return false;
    }


    public static void main(String[] args) {
//        输入: root = [5,3,6,2,4,null,7], k = 9
//        输出: true
        TreeNode root = new TreeNode(5,new TreeNode(3,new TreeNode(2),new TreeNode(4)),new TreeNode(6,null,new TreeNode(7)));

        System.out.println(findTarget(root, 9));
    }

}
