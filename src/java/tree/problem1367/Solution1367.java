package tree.problem1367;

/**
 * @author mango
 * @version 1.0
 * @description 1367. 二叉树中的列表
 * @email
 * @date 2022/4/14 10:27
 */
public class Solution1367 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        return find(head, root) || isSubPath(head, root.getLeft()) || isSubPath(head, root.getRight());
    }

    private boolean find(ListNode head, TreeNode node) {
        if (head == null) {
            return true;
        }
        if (node == null || head.getVal() != node.getVal()) {
            return false;
        }
        return find(head.getNext(), node.getLeft()) || find(head.getNext(), node.getRight());
    }
}
