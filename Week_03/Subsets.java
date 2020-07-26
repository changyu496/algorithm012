package Week_03;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    /**
     * 子集
     * <p>
     * leetcode:https://leetcode-cn.com/problems/subsets/
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        // 求全部子集，这个题目非常高频，也是有多种解法，注意要避免人肉递归
        // 典型的回溯问题？
        // 方法1，在递归的方法里，依次放进去，当遍历完nums，就把结果放到最终的集合里，然后在递归里面还有个循环
        // 出来的时候要注意清理现场
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    private void helper(int index, int[] nums, List<Integer> ret, List<List<Integer>> ans) {
        // 终止条件 是在循环控制的终止条件
        // 这句话很重要，不能直接放ret进来
        ans.add(new ArrayList<>(ret));
        for (int i = index; i < nums.length; i++) {
            // 处理当前层逻辑
            ret.add(nums[i]);
            // 递归下一层，注意条件
            helper(i + 1, nums, ret, ans);
            // 清理数据
            ret.remove(ret.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> ans = subsets.subsets(new int[]{1, 2, 3});
        System.out.println(ans);
    }


}
