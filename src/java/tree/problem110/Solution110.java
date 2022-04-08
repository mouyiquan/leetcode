package tree.problem110;

/**
 * @author mango
 * @version 1.0
 * @description TODO
 * @email
 * @date 2022/4/8 9:04
 */
public class Solution110 {

    public boolean isBalanced(TreeNode root){
        return height(root) >= 0;
    }

    public int height(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftHeight = height(root.getLeft());
        int rightHeight = height(root.getRight());

        if (Math.abs(leftHeight - rightHeight)>1 || leftHeight == -1 || rightHeight == -1){
            return -1;
        }else {
            //返回当前节点的度
            return Math.max(leftHeight,rightHeight) + 1;
        }

    }


}
