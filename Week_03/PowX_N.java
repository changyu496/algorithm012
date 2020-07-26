package Week_03;

public class PowX_N {
    /**
     * 50. Pow(x, n)
     * <p>
     * leetcode:https://leetcode-cn.com/problems/powx-n/
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        // 分治（递归的思路）
        return n > 0 ? fastPow(x, n) : 1.0 / fastPow(x, n * -1);
    }

    private double fastPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n % 2 == 1) {
            return fastPow(x, n / 2) * fastPow(x, n / 2) * x;
        } else {
            return fastPow(x, n / 2) * fastPow(x, n / 2);
        }
    }

    public static void main(String[] args) {
        PowX_N powX_n = new PowX_N();
        System.out.println(powX_n.myPow(2.00000, -2147483648));
    }
}
