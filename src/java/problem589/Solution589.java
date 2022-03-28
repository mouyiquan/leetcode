package problem589;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mango
 * @version 1.0
 * @description TODO
 * @email
 * @date 2022/3/28 11:08
 */
public class Solution589 {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node ch : root.children) {
            helper(ch, res);
        }
    }
}
