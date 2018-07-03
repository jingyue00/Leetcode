/**
 * Solution: go through array prices. The profit start with 0, and hold start with -prices[0]
 *      each time compare to get larger profit, profit = Math.max(profit, hold + prices[i] - fee);
 *      Then compare the previous hold number with current hold number and get larger one.
 *      Important: hold number get from profit - current buying price.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class BestTimetoBuyandSellStockwithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int profit = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, hold + prices[i] - fee);
            hold = Math.max(hold, profit - prices[i]);
        }
        return profit;
    }
}
