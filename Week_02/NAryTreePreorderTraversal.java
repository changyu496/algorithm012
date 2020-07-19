package Week_02;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePreorderTraversal {

    /**
     * 589. N叉树的前序遍历
     * <p>
     * leetcode:https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        helper(root, ret);
        return ret;
    }

    private void helper(Node node, List<Integer> ret) {
        if (node == null) {
            return;
        } else {
            ret.add(node.val);
            for (int i = 0; i < node.children.size(); i++) {
                helper(node.children.get(i), ret);
            }
        }
    }

}
