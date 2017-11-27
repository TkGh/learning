package leetCode1;

import java.util.Arrays;

public class BestTime2BuyNSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices.length <= 1 || k < 1) {
            return 0;
        }

        if (k >= prices.length / 2) {
            return helper(prices);
        }

        int[] buy = new int[k];
        int[] sell = new int[k];
        Arrays.fill(buy, Integer.MIN_VALUE);
        Arrays.fill(sell, 0);
        for (int p : prices) {
            for (int i = 0; i < k - 1; i++) {
                sell[i] = Math.max(sell[i], buy[i] + p);
                buy[i] = Math.max(buy[i], sell[i + 1] - p);
            }
            sell[k - 1] = Math.max(sell[k - 1], buy[k - 1] + p);
            buy[k - 1] = Math.max(buy[k - 1], -p);
        }

        return sell[0];
    }

    private int helper(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i];
            }
        }
        return profit;
    }
}
