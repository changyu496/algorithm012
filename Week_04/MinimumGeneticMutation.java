package Week_04;

import java.util.*;

public class MinimumGeneticMutation {

    /**
     * 433. 最小基因变化
     * <p>
     * leetcode:https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description
     *
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {
        // 这是一道上来就没什么概念的题目
        // 基本思路上来题解说是BFS，其实我是有点懵的，但BFS的套路模版得先写上
        // 后面可以简单理解为，依次替换每个位置，没替换依次记录一个level？
        if (start.equals(end)) {
            return 0;
        }
        HashSet<String> bankSet = new HashSet<>();
        for (String b : bank) {
            bankSet.add(b);
        }
        Queue<String> queue = new ArrayDeque<>();
        List<String> visited = new ArrayList<>();
        char[] chars = new char[]{'A', 'C', 'G', 'T'};
        int level = 0;
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                if (cur.equals(end)) {
                    return level;
                }
                char[] curArray = cur.toCharArray();
                for (int i = 0; i < curArray.length; i++) {
                    char oldChar = curArray[i];
                    for (char c : chars) {
                        curArray[i] = c;
                        String next = new String(curArray);
                        if (!visited.contains(next) && bankSet.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                    curArray[i] = oldChar;
                }
            }
            level++;
        }
        return -1;
    }
}
