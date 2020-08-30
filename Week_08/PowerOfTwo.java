package Week_08;

/**
 * 231. 2的幂
 * <p>
 * https://leetcode-cn.com/problems/power-of-two/
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        // 从二进制角度看，就全是1？
        if (n == 0) {
            return false;
        }
        long x = n;
        return (x & (x - 1)) == 0;
    }
}
