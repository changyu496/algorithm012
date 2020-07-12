package Week_01;

import java.util.HashMap;

public class TwoSum {
  /**
   * 两数之和
   * 
   * leetcode https://leetcode-cn.com/problems/two-sum/
   * 
   * @param nums
   * @param target
   * @return
   */
  public int[] twoSum(int[] nums, int target) {
    // 这道题实在是做了非常非常非常多遍了，因为没有办法排序，所以就还是是用Hash表来保存
    HashMap<Integer, Integer> maps = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (maps.containsKey(target - nums[i])) {
        return new int[] { maps.get(target - nums[i]), i };
      } else {
        maps.put(nums[i], i);
      }
    }
    return new int[] {};

  }

}