package Week_03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MajorityElement {

    /**
     * 169. 多数元素
     * <p>
     * leetcode:https://leetcode-cn.com/problems/majority-element/description/
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        // 第一反应还是用map保存一次出现次数？
        // 题目提示是有分支，那么就分一半，看是不是包括，如果不包括，就不是，然后再分一半？不是很能想象
        // 先用map做一次？
        AtomicInteger ans = new AtomicInteger();
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!maps.containsKey(nums[i])) {
                maps.put(nums[i], 0);
            }
            maps.put(nums[i], maps.get(nums[i]) + 1);
        }
        maps.keySet().forEach(val -> {
            if (maps.get(val) > nums.length / 2) {
                ans.set(val);
            }
        });
        return ans.get();
    }

    public int majorityElementV2(int[] nums) {
        // 利用排序的思路
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
