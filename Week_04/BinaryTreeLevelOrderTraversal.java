package Week_04;

import Week_02.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    /**
     * 102. 二叉树的层序遍历
     * <p>
     * leetcode:https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 按照层序遍历，非常容易想到这是一个BFS
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (queue.peek().left != null) {
                    queue.add(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.add(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            ret.add(new ArrayList<>(subList));
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(9);
        TreeNode r1 = new TreeNode(20);
        TreeNode r1l2 = new TreeNode(15);
        TreeNode r1r2 = new TreeNode(7);
        root.left = l1;
        root.right = r1;
        r1.left = r1l2;
        r1.right = r1r2;
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        binaryTreeLevelOrderTraversal.levelOrder(root);
    }
}
