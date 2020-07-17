package Week_02;

import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindowForce(int[] nums, int k) {
        // 暴力法，遍历每个滑动窗口，找到每个窗口的最大值
        // 一共有n-k+1个窗口
        int n = nums.length;

        int[] output = new int[n - k + 1];
        // 遍历窗口
        for (int i = 0; i < n - k + 1; i++) {
            // 遍历窗口里每个值
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            output[i] = max;
        }
        return output;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 思路，用一个单调递减队列（或是说从大到小的队列）来保存遍历的数据
        // 同时记录在遍历的时候，是否已经过了窗口，如果过了，就要把该元素从队列中移除
        // 同时在滑动窗口到了的时候，队列里的头，就是这个窗口内的最大值，首先因为这是一个从大到小的队列，其次，不在窗口的都被干掉了
        if (nums != null || nums.length < 2) {
            return new int[]{};
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int n = nums.length;
        int[] ret = new int[n - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            // 判断当前队首是否有效
            if (queue.peek() < i + k) {
                queue.poll();
            }
            if (i + 1 >= k) {
                ret[i + 1 - k] = queue.peek();
            }
        }
        return ret;
    }
}
