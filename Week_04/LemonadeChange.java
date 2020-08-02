package Week_04;

public class LemonadeChange {

    /**
     * 860. 柠檬水找零
     * <p>
     * leetcode:https://leetcode-cn.com/problems/lemonade-change/
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        // 真正去模拟实际操作
        // 贪心只是一种思想
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                ten++;
                five--;
            } else {
                if (five > 0 && ten > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                }
            }
            if (five < 0 || ten < 0) {
                return false;
            }
        }
        return true;
    }
}
