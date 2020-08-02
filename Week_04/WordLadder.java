package Week_04;

import java.util.*;

public class WordLadder {

    /**
     * 127. 单词接龙
     * <p>
     * leetcode:https://leetcode-cn.com/problems/word-ladder/
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 这道题和基因的思路很相似
        // 最短路径，默认用BFS？
        if (beginWord.equals(endWord)) {
            return 0;
        }
        // 注意这里一定要用HashSet，不能用List，否则效率太低了
        HashSet<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);
        Queue<String> queue = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        char[] chars = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        queue.add(beginWord);
        visited.add(beginWord);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                if (endWord.equals(curWord)) {
                    return count;
                }
                char[] curArray = curWord.toCharArray();
                for (int j = 0; j < curArray.length; j++) {
                    char oldChar = curArray[j];
                    for (char c : chars) {
                        curArray[j] = c;
                        String next = new String(curArray);
                        if (!visited.contains(next) && wordSet.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                    curArray[j] = oldChar;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        int count = wordLadder.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(count);
    }
}
