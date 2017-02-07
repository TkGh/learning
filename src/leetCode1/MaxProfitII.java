package leetCode1;

public class MaxProfitII {
	public int maxProfit(int[] prices) {
		if (prices.length == 0 || prices.length == 1) {
			return 0;
		}

		int size = prices.length;
		int max = prices[0];
		int min = prices[0];
		int temp = 0;
		int profit = 0;

		for (int i = 0; i < size; i++) {
			if (prices[i] < min) {
				temp = max - min;
				profit += temp;
				min = prices[i];
				max = prices[i];
			} else {
				if (prices[i] > max) {
					max = prices[i];
				} else if (prices[i] < max) {
					temp = max - min;
					profit += temp;
					min = prices[i];
					max = prices[i];
				}
			}
		}

		profit += (max - min);

		return profit;
	}

	public static void main(String[] args) {
		int[] a = { 6, 1, 3, 2, 4, 7 };
		MaxProfitII b = new MaxProfitII();
		System.out.println(b.maxProfit(a));
	}
}
