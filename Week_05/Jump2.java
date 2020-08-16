package Week_05;

public class Jump2 {
    /**
     * 45. 跳跃游戏 II
     * <p>
     * https://leetcode-cn.com/problems/jump-game-ii/
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        // 逆向找
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                // 从这个位置可以跳到
                if (i + nums[i] >= position) {
                    steps++;
                    position = i;
                    break;
                }
            }
        }
        return steps;
    }

    public int jump2(int[] nums) {
        int length = nums.length;
        int maxPosition = 0;
        int end = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

}
