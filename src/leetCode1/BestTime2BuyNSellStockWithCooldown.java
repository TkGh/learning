package leetCode1;

public class BestTime2BuyNSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        if (n <= 1) return 0;

        int s_pre = 0;
        int s = 0;
        int h = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int s_old = s;
            s = Math.max(s, h + prices[i]);
            h = Math.max(h, s_pre - prices[i]);
            s_pre = s_old;
        }

        return s;
    }
}
