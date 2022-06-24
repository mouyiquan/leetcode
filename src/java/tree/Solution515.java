package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mango
 * @version 1.0
 * @description 515. 在每个树行中找最大值
 * https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
 * @email
 * @date 2022/6/24 8:39
 */
public class Solution515 {

    Map<Integer, Integer> map = new HashMap<>();

    //DFS
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null){
            return result;
        }


        result.add(root.val);


        if (root.left!=null){
            dfs(root.left,1);
        }

        if (root.right!=null){
            dfs(root.right,1);
        }

        if (!map.isEmpty()){
            for (int i = 1; i <= map.size(); i++) {
                result.add(map.get(i));
            }
        }

        return result;
    }

    public void dfs(TreeNode root, Integer level){

        if (map.containsKey(level)){
            map.put(level, Math.max(map.get(level), root.val));
        }else {
            map.put(level,root.val);
        }

        if (root.left!=null){
            dfs(root.left,level+1);
        }

        if (root.right!=null){
            dfs(root.right,level+1);
        }
    }

}
