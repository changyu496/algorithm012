package Week_03;

import Week_02.TreeNode;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {
    /**
     * 二叉树的序列化与反序列化
     * <p>
     * leetcode:https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
     *
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 默认应该每个位置都应该存？当作满二叉树的思路，如果没有就放null
        // 知道深度，才能知道数组的长度？用arrayList吧
        return helperSerialize(root, "");
    }

    private String helperSerialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += root.val + ",";
            str = helperSerialize(root.left, str);
            str = helperSerialize(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] array = data.split(",");
        return helperDeserialize(new LinkedList<>(Arrays.asList(array)));
    }

    private TreeNode helperDeserialize(List<String> list) {
        if (list.get(0) == null) {
            list.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        node.left = helperDeserialize(list);
        node.right = helperDeserialize(list);
        return node;

    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree serializeAndDeserializeBinaryTree = new SerializeAndDeserializeBinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode r1l2 = new TreeNode(4);
        TreeNode r1r2 = new TreeNode(5);
        root.left = l1;
        root.right = r1;
        r1.left = r1l2;
        r1.right = r1r2;
        String str = serializeAndDeserializeBinaryTree.serialize(root);
        System.out.println(str);
    }


    public String serializeV2(TreeNode root) {
        // 使用先序遍历的思路？
        return preOrderSerializeV2("", root);
    }

    private String preOrderSerializeV2(String str, TreeNode node) {
        if (node == null) {
            return str + "None,";
        }
        str += node.val + ",";
        str = preOrderSerializeV2(str, node.left);
        str = preOrderSerializeV2(str, node.right);
        return str;
    }

    public TreeNode deserializeV2(String data) {
        String[] dataList = data.split(",");
        // 反序列化没思路
        return deserializeV2Helper(new LinkedList(Arrays.asList(dataList)));
    }

    private TreeNode deserializeV2Helper(List<String> list) {
        if ("None".equals(list.get(0))) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = deserializeV2Helper(list);
        root.right = deserializeV2Helper(list);
        return root;

    }

}
