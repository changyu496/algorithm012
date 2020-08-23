package Week_07;

import java.util.HashMap;

/**
 * 208. 实现 Trie (前缀树)
 * <p>
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */
public class Trie {

    private class TreeNode {
        private HashMap<Character, TreeNode> links;

        private boolean isWordEnd;

        TreeNode() {
            links = new HashMap<>();
            isWordEnd = false;
        }

        public boolean containsKey(Character character) {
            return links.containsKey(character);
        }

        public TreeNode get(Character character) {
            if (containsKey(character)) {
                return links.get(character);
            } else {
                return null;
            }
        }

        public void put(Character character, TreeNode node) {
            if (!containsKey(character)) {
                links.put(character, node);
            }
        }
    }

    private TreeNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TreeNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TreeNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char curCharacter = word.charAt(i);
            cur.put(curCharacter, new TreeNode());
            cur = cur.get(curCharacter);
        }
        cur.isWordEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TreeNode cur = _search(word);
        return cur != null && cur.isWordEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return _search(prefix) != null;
    }

    private TreeNode _search(String word) {
        TreeNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char curCharacter = word.charAt(i);
            if (!cur.containsKey(curCharacter)) {
                return null;
            } else {
                cur = cur.get(curCharacter);
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        trie.search("apps");
        System.out.println(trie.search("app"));
    }
}
