package offer;

/**
 * @author mango
 * @version 1.0
 * @description 剑指 Offer 27. 二叉树的镜像
 * @email
 * @date 2022/6/17 11:11
 */
public class Offer27 {

    public TreeNode mirrorTree(TreeNode root) {

        if (root == null){
            return root;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }

}
