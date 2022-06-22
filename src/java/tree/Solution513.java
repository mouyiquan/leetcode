package tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author mango
 * @version 1.0
 * @description 513. 找树左下角的值
 * @email
 * @date 2022/6/22 8:06
 */
public class Solution513 {


    public int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode peek = queue.peek();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }

            if (queue.isEmpty()) {
                return peek.val;
            }
        }

        return 0;
    }


}
