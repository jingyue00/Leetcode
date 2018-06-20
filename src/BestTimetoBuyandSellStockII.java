/**
 * Solution: if prices[i] > prices[i - 1], keep add difference to profit;
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class BestTimetoBuyandSellStockII {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                maxProfit += (prices[i] - prices[i - 1]);
            }
        }
        return maxProfit;
    }

    public int maxProfitII(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                min = prices[i];
            }
            if (i == prices.length - 1 || prices[i] > prices[i + 1]) {
                maxProfit += Math.max(0, prices[i] - min);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimetoBuyandSellStockII btbssII = new BestTimetoBuyandSellStockII();
        System.out.println(btbssII.maxProfit(new int[]{17,1,5,3,6,4}));
        System.out.println(btbssII.maxProfitII(new int[]{7,6,4,3,1}));
    }
}
