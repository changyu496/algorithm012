package Week_05;

public class Jump {

    public boolean jump(int[] nums) {
        // 上来就先能想到暴力
        // 如果逆向分析？贪心？最后一步能调的位置？
        // 倒着贪心？
        int rightMost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > rightMost) {
                return false;
            }
            rightMost = Math.max(rightMost, i + nums[i]);
        }
        return true;
    }
}
