package leetCode1;

public class MaxProfit {
	public int maxProfit(int[] prices) {
		if (prices.length == 0 || prices.length == 1) {
			return 0;
		}

		int size = prices.length;
		int max = prices[0];
		int min = prices[0];
		int profit = 0;
		int temp = 0;

		for (int i = 0; i < size; i++) {
			if (prices[i] < min) {
				temp = max - min;
				if (temp > profit) {
					profit = temp;
				}
				min = prices[i];
				max = prices[i];
			} else {
				if (prices[i] > max) {
					max = prices[i];
					temp = max - min;
					if (temp > profit) {
						profit = temp;
					}
				}
			}
		}

		return profit;
	}

	public static void main(String[] args) {
		int[] a = { 3, 2, 6, 5, 0, 3 };
		MaxProfit b = new MaxProfit();
		System.out.println(b.maxProfit(a));
	}
}
