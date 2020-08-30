package Week_08;

import java.util.*;

/**
 * 146. LRU缓存机制
 * <p>
 * https://leetcode-cn.com/problems/lru-cache/#/
 */
public class LRUCache {
    // 最近最少，用一个队列保存？
    class Node {
        private int key;
        private int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return key == node.key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }

    private Deque<Node> list;
    private int capacity;
    private HashMap<Integer, Node> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.list = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node != null) {
            list.remove(node);
            list.addFirst(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node needAdd;
        if (Objects.nonNull(cache.get(key))) {
            needAdd = cache.get(key);
            needAdd.value = value;
            list.remove(needAdd);
            list.addFirst(needAdd);
            cache.put(key, needAdd);
            return;
        }
        if (list.size() >= capacity) {
            cache.remove(list.getLast().key);
            list.removeLast();
        }
        needAdd = new Node(key, value);
        list.addFirst(needAdd);
        cache.put(key, needAdd);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);

        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));       // 返回 -1
        System.out.println(cache.get(2));       // 返回 3 (未找到)
    }

}
