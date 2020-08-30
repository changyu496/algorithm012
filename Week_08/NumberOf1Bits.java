package Week_08;

/**
 * 191. 位1的个数
 * <p>
 * https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int bitCount = 0;
        while (n != 0) {
            n = n & (n - 1);
            bitCount++;
        }
        return bitCount;
    }
}
