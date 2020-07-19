package Week_02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryLevelOrderTraversal {
    /**
     * 429. N叉树的层序遍历
     * <p>
     * leetcode:https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        // 使用队列，保存一层的数据，吐出后，然后再把下一层的放到队列里
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);
                queue.addAll(node.children);
            }
            ret.add(list);
        }
        return ret;
    }
}
