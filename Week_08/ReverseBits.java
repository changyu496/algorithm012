package Week_08;

/**
 * 190. 颠倒二进制位
 * <p>
 * https://leetcode-cn.com/problems/reverse-bits/
 */
public class ReverseBits {

    public int reverseBits(int n) {
        // 循环右移动，然后再搞
        int ans = 0;
        for (int i = 31; i > 0; n = n >>> 1, i--) {
            ans += (n & 1) << i;
        }
        return ans;
    }
}
