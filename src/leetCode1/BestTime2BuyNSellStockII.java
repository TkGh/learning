package leetCode1;

public class BestTime2BuyNSellStockII {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int sum = 0;
        for (int i = prices.length - 1; i > 0; i--) {
            prices[i] = prices[i] - prices[i - 1];
            if (prices[i] > 0) {
                sum += prices[i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] test = {7, 1, 5, 3, 6, 4};
        System.out.println(new BestTime2BuyNSellStockII().maxProfit(test));
    }
}
