package leetCode1;

public class BestTime2BuyNSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        //Imaging we would buy n sell on every price, replace the prices with gaps, and find the max sum:
        for (int i = prices.length - 1; i > 0; i--) {
            prices[i] = prices[i] - prices[i - 1];
        }

        int sum = 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            sum = Math.max(prices[i], sum + prices[i]);
            max = Math.max(sum, max);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] test = {5,3,2,1};
        System.out.println(new BestTime2BuyNSellStock().maxProfit(test));
    }
}
