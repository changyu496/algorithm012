package Week_03;

import Week_02.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {

    /**
     * 98. 验证二叉搜索树
     * <p>
     * https://leetcode-cn.com/problems/validate-binary-search-tree/
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        // 递归的写法不太容易
        // 就先利用中序遍历，应该是升序的思路吧
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        // 判断list是不是单调递增的
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void helper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        helper(node.left, list);
        list.add(node.val);
        helper(node.right, list);
    }
}
