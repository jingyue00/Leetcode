/**
 * Solution: go through the array, compare with the lowest price and record max profit
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0 || prices[i] < min) {
                min = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - min);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimetoBuyandSellStock btbss = new BestTimetoBuyandSellStock();
        System.out.println(btbss.maxProfit(new int[]{17,1,5,3,6,4}));
        System.out.println(btbss.maxProfit(new int[]{7,6,4,3,1}));
    }
}
