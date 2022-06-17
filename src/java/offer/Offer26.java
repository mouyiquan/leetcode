package offer;

/**
 * @author mango
 * @version 1.0
 * @description 剑指 Offer 26. 树的子结构
 * @email
 * @date 2022/6/17 10:28
 */
public class Offer26 {

    
    public boolean check(TreeNode a, TreeNode b) {

        if (a == null || b == null) {
            return b == null;
        }

        return a.val == b.val && check(a.left, b.right) && check(a.right, b.right);
    }

    public boolean isSubStructure(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) return false; // node2 为null时无论node1是否为null都是true
        return check(node1,node2) || isSubStructure(node1.left, node2) || isSubStructure(node1.right, node2);
    }

}
