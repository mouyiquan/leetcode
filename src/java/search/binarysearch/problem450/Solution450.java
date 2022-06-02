package search.binarysearch.problem450;

import tree.problem110.TreeNode;

/**
 * @author mango
 * @version 1.0
 * @description TODO
 * @email
 * @date 2022/6/2 8:41
 */
public class Solution450 {


    /**
     * 根据二叉搜索树的性质
     *
     *     如果目标节点大于当前节点值，则去右子树中删除；
     *     如果目标节点小于当前节点值，则去左子树中删除；
     *     如果目标节点就是当前节点，分为以下三种情况：
         *     其无左子：其右子顶替其位置，删除了该节点；
         *     其无右子：其左子顶替其位置，删除了该节点；
         *     其左右子节点都有：其左子树转移到其右子树的最左节点的左子树上，然后右子树顶替其位置，由此删除了该节点。
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return root;
        }
        
        int val = root.getVal();
        
        if (val < key){
            root.setRight(deleteNode(root.getRight(),key));
            return root;
        }
        if (val > key){
            root.setLeft(deleteNode(root.getLeft(),key));
            return root;
        }
        
        TreeNode left = root.getLeft();
        TreeNode right = root.getRight();
        if (left == null && right ==null){
            return null;
        }
        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }

        root = right;
        TreeNode rightLeft = right;
        while(rightLeft.getLeft()!=null){
            rightLeft = rightLeft.getLeft();
        }
        rightLeft.setLeft(left);

        
        return root;
    }
    

}
