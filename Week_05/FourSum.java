package Week_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    /**
     * 18.四数之和
     * <p>
     * https://leetcode-cn.com/problems/4sum/
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 思路：排序后，逐步退化为2Sum问题，注意其中的剪枝处理，比如重复数字的过滤
        // 还要注意去重
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4) {
            return ans;
        }
        Arrays.sort(nums);
        int len = nums.length;
        if (target < nums[0] + nums[1] + nums[2] + nums[3] || target > nums[len - 1] + nums[len - 2] + nums[len - 3] + nums[len - 4]) {
            return ans;
        }
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int newTarget = target - (nums[i] + nums[j]);
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    if (newTarget == nums[left] + nums[right]) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        while (left < right && nums[left - 1] == nums[left]) {
                            left++;
                        }
                        right--;
                        while (left < right && nums[right + 1] == nums[right]) {
                            right--;
                        }
                    } else if (newTarget > nums[left] + nums[right]) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        List<List<Integer>> ans = fourSum.fourSum(new int[]{0, 0, 0, 0}, 0);
        System.out.println(ans);
    }
}
