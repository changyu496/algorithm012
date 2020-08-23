package Week_07;

import java.util.*;

/**
 * 212. 单词搜索 II
 * <p>
 * https://leetcode-cn.com/problems/word-search-ii/
 */
public class WordSearchII {

    public static void main(String[] args) {
        String[] words = new String[]{"a"};
        char[][] board = new char[][]{
                {'a', 'a'}
        };
        WordSearchII wordSearchII = new WordSearchII();

        List<String> ret = wordSearchII.findWords(board, words);
        System.out.println(ret);
    }

    public List<String> findWords(char[][] board, String[] words) {
        // 第一步 构建Trie
        Set<String> ret = new HashSet<>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        // DFS
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, "", i, j, trie, ret);
            }
        }
        // 组装结果
        return new ArrayList<>(ret);
    }

    private void dfs(char[][] board, String curStr, int i, int j, Trie trie, Set<String> ret) {
        // 终止条件
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '@') {
            return;
        }
        // 处理本层
        curStr += board[i][j];
        Trie.TreeNode curNode = trie.search(curStr);
        if (curNode == null) {
            return;
        } else if (curNode.isWordEnd) {
            ret.add(curStr);
        }
        char temp = board[i][j];
        board[i][j] = '@';
        // 下钻到下一层
        dfs(board, curStr, i + 1, j, trie, ret);
        dfs(board, curStr, i, j + 1, trie, ret);
        dfs(board, curStr, i, j - 1, trie, ret);
        dfs(board, curStr, i - 1, j, trie, ret);
        // 恢复状态
        board[i][j] = temp;
    }

    private class Trie {

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

        public TreeNode search(String word) {
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
    }
}
