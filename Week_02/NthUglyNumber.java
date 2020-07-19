package Week_02;

import java.util.*;

public class NthUglyNumber {

    /**
     * 264. 丑数 II
     * <p>
     * lettcode:https://leetcode-cn.com/problems/ugly-number-ii/
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        TreeSet<Long> treeSet = new TreeSet<>();
        int count = 0;
        long result = 1;
        treeSet.add(result);
        while (count < n) {
            result = treeSet.pollFirst();
            count++;
            treeSet.add(result * 2);
            treeSet.add(result * 3);
            treeSet.add(result * 5);
        }
        return (int) result;
    }

    public int nthUglyNumberForce(int n) {
        // 也是一道没有什么特别思路的题目
        // 先暴力法，求出所有的丑树，然后放到一个数组里，像取几个就是几个？
        // 逻辑可行，但会超出时间限制
        int MAX_NUMS = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= MAX_NUMS; i = i * 2) {
            for (int j = i; j <= MAX_NUMS; j = j * 3) {
                for (int k = j; k <= MAX_NUMS; k = k * 5) {
                    list.add(k);
                }
            }
        }
        list.sort(Comparator.comparingInt(o -> o));
        return list.get(n);
    }

    public static void main(String[] args) {
        NthUglyNumber nthUglyNumber = new NthUglyNumber();
        int ret = nthUglyNumber.nthUglyNumber(10);
        System.out.println(ret);
    }
}
