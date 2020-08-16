package Week_05;

public class Sqrtx {
    /**
     * 69. x 的平方根
     * <p>
     * leetcode:https://leetcode-cn.com/problems/sqrtx/
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        // 二分查找
        int left = 0;
        int right = x;
        int ret = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) (mid * mid) <= x) {
                ret = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Sqrtx sqrtx = new Sqrtx();
        int x = sqrtx.mySqrt(4);
        System.out.println(x);
    }
}
