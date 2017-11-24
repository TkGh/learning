package leetCode1;

import java.util.Arrays;

public class BestTime2BuyNSellStockIII {
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for (int i : prices) {                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2 + i);     // The maximum if we've just sold 2nd stock so far.
            hold2 = Math.max(hold2, release1 - i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1 + i);     // The maximum if we've just sold 1nd stock so far.
            hold1 = Math.max(hold1, -i);          // The maximum if we've just buy  1st stock so far.
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }

    public static void main(String[] args) {
        int[] test = {2, 6, 8, 7, 8, 7, 9, 4, 1, 2, 4, 5, 8};
        System.out.println(new BestTime2BuyNSellStockIII().maxProfit(test));
    }
}

/**
 * Wrong answer
 */
//class Solution{
//    public int maxProfit(int[] prices) {
//        if (prices.length <= 1) {
//            return 0;
//        }
//
//        for (int i = prices.length - 1; i > 0; i--) {
//            prices[i] = prices[i] - prices[i - 1];
//        }
//
//        if (prices.length == 2) {
//            return prices[1] < 0 ? 0 : prices[1];
//        }
//
//        int res = 0;
//        int last = 0;
//        prices[0] = 0;
//        int i = 0;
//        while (i < prices.length && prices[i] <= 0) {
//            prices[i] = 0;
//            i++;
//        }
//
//        int end = prices.length - 1;
//        while (end > 0 && prices[end] <= 0) {
//            prices[end] = 0;
//            end--;
//        }
//
//        for (; i <= end; i++) {
//            int tmpMinus = 0;
//            while (i <= end && prices[i] <= 0) {
//                tmpMinus += prices[i];
//                i++;
//            }
//            int tmpMax = 0;
//            while (i <= end && prices[i] > 0) {
//                tmpMax += prices[i];
//                prices[i] = 0;
//                i++;
//            }
//            i--;
//            res = Math.max(res, Math.max(prices[last], prices[last] + tmpMax));
//            if (prices[last] + tmpMax + tmpMinus >= tmpMax) {
//                if (prices[last] > prices[last] + tmpMax + tmpMinus) {
//                    prices[i] = prices[last];
//                } else {
//                    prices[i] = prices[last] + tmpMax + tmpMinus;
//                }
//                prices[last] = 0;
//            } else {
//                prices[i] = tmpMax;
//            }
//
//            last = i;
//        }
//
//        int sum = 0;
//        Arrays.sort(prices);
//        if (prices[prices.length - 1] > 0) {
//            sum += prices[prices.length - 1];
//        }
//        if (prices[prices.length - 2] > 0) {
//            sum += prices[prices.length - 2];
//        }
//
//        return Math.max(sum, res);
//    }
//}