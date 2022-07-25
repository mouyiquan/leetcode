package tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author mango
 * @version 1.0
 * @description 919. 完全二叉树插入器
 * https://leetcode.cn/problems/complete-binary-tree-inserter/
 * @email
 * @date 2022/7/25 8:52
 */
public class Solution919 {

    Queue<TreeNode> candidate;
    TreeNode root;

    public Solution919(TreeNode root) {
        this.candidate = new ArrayDeque<TreeNode>();
        this.root = root;

        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (!(node.left != null && node.right != null)) {
                candidate.offer(node);
            }
        }
    }

    public int insert(int val) {
        TreeNode child = new TreeNode(val);
        TreeNode node = candidate.peek();
        int ret = node.val;
            if (node.left == null) {
                node.left = child;
            } else {
                node.right = child;
                candidate.poll();
        }
        candidate.offer(child);
        return ret;
    }

    public TreeNode get_root() {
        return root;
    }

}
