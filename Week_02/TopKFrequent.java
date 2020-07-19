package Week_02;

import java.util.*;

public class TopKFrequent {

    /**
     * 347. 前 K 个高频元素
     * <p>
     * leetcode:https://leetcode-cn.com/problems/top-k-frequent-elements/
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        // 只要看到TopK的问题，立刻就要能想到堆
        // 方法，先遍历一遍nums，把出现频率存起来
        List<Integer> ret = new ArrayList<>();
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int key : nums) {
            if (maps.containsKey(key)) {
                maps.put(key, maps.get(key) + 1);
            } else {
                maps.put(key, 1);
            }
        }
        // 这里的操作，之前没想到
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(maps::get));
        for (Integer key : maps.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (maps.get(key) > maps.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        while (!pq.isEmpty()) {
            ret.add(pq.remove());
        }
        return ret.stream().mapToInt(Integer::valueOf).toArray();

    }

    public int[] topKFrequentV1(int[] nums, int k) {
        // 只要看到TopK的问题，立刻就要能想到堆
        // 方法，先遍历一遍nums，把出现频率存起来
        List<Integer> ret = new ArrayList<>();
        HashMap<Integer, NumsWithFrequent> maps = new HashMap<>();
        for (int key : nums) {
            if (maps.containsKey(key)) {
                maps.put(key, new NumsWithFrequent(key, maps.get(key).frequent + 1));
            } else {
                maps.put(key, new NumsWithFrequent(key, 1));
            }
        }
        PriorityQueue<NumsWithFrequent> queue = new PriorityQueue((Comparator<NumsWithFrequent>) (o1, o2) -> o2.frequent - o1.frequent);
        queue.addAll(maps.values());
        for (int i = 0; i < k; i++) {
            ret.add(queue.poll().val);
        }
        return ret.stream().mapToInt(Integer::valueOf).toArray();

    }

    private class NumsWithFrequent {
        int val;
        int frequent;

        public NumsWithFrequent(int val, int frequent) {
            this.val = val;
            this.frequent = frequent;
        }
    }
}
