package Week_04;

public class BestTimeToBuyAndSellStockII {
    /**
     * 122. 买卖股票的最佳时机 II
     * <p>
     * leetcode:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // 这道题的点不在于代码，而在于理解
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }
}
