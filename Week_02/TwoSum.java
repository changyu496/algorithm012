package Week_02;

import java.util.HashMap;

public class TwoSum {
    /**
     * 两数之和
     * <p>
     * leetcode:https://leetcode-cn.com/problems/two-sum/
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        // 做了非常非常多遍，也是HashMap的一个经典用法
        // 谁让他是LeetCode的第一道题呢
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (maps.containsKey(target - nums[i])) {
                return new int[]{maps.get(target - nums[i]), i};
            } else {
                maps.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
