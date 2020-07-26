package Week_03;

public class RunningSumOf1dArray {

    /**
     * 1480. 一维数组的动态和
     * <p>
     * leetcode:https://leetcode-cn.com/problems/running-sum-of-1d-array/
     *
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {
        // 为了锻炼下递归，就先用递归写一次吧
        helper(1, nums);
        return nums;
    }

    private void helper(int index, int[] nums) {
        // 终止条件
        if (index == nums.length) {
            return;
        }
        // 处理当前层逻辑
        nums[index] = nums[index - 1] + nums[index];
        // 递归到下一层
        helper(index + 1, nums);
        // 清理当前层
    }

    public static void main(String[] args) {
        RunningSumOf1dArray runningSumOf1dArray = new RunningSumOf1dArray();
        int[] nums = new int[]{1, 2, 3, 4};
        runningSumOf1dArray.runningSum(nums);
        System.out.println(nums);
    }
}
