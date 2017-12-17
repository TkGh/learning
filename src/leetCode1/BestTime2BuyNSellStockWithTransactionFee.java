package leetCode1;

public class BestTime2BuyNSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        if (n <= 1) return 0;

        int hold = Integer.MIN_VALUE;
        int sell = 0;

        for (int i = 0; i < n; i++) {
            sell = Math.max(sell, hold + prices[i]);
            hold = Math.max(hold, sell - prices[i] - fee);
        }

        return sell;
    }

    public static void main(String[] args) {
        int[] test = {1, 3, 2, 8, 4, 9};
        System.out.print(new BestTime2BuyNSellStockWithTransactionFee().maxProfit(test, 2));
    }
}
