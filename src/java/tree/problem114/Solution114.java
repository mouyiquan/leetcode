package tree.problem114;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mango
 * @version 1.0
 * @description 114. 二叉树展开为链表
 * @email
 * @date 2022/4/18 9:13
 */
public class Solution114 {

    public void flatten(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        if (root != null){
            list.add(root.getVal());
            if (root.getLeft() != null){
                dfs(root.getLeft(),list);
            }
            if (root.getRight() != null){
                dfs(root.getRight(),list);
            }
        }
        System.out.println("[");
        for (int i = 0; i < list.size()-1; i++) {
            System.out.println(list.get(i));
            System.out.println(",null,");
        }
        if (list.size()>0){
            System.out.println(list.get(list.size() - 1));
        }
        System.out.println("]");

    }

    private void dfs(TreeNode root, List<Integer> list){
        if (root != null){
            list.add(root.getVal());
            if (root.getLeft() != null){
                dfs(root.getLeft(),list);
            }
            if (root.getRight() != null){
                dfs(root.getRight(),list);
            }
        }
    }



}
