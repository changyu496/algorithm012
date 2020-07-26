package Week_03;

public class ClimbingStairs {

    /**
     * 70. 爬楼梯
     * <p>
     * leetcode:https://leetcode-cn.com/problems/climbing-stairs/
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        // 第三级台阶的走法等于 第一级台阶走两步骤+ 第二级台阶的走一步
        // f(n) = f(n-1)+f(n-2)
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int f1 = 1;
        int f2 = 2;
        int f3 = 3;
        for (int i = 2; i < n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
