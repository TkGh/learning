package leetCode1;

public class MaxProduct {
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}

		int max = nums[0];
		int min = nums[0];
		int res = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int tempMax = max;
			max = Math.max(Math.max(nums[i] * max, nums[i]), min * nums[i]);
			min = Math.min(Math.min(nums[i] * tempMax, nums[i]), min * nums[i]);
			res = Math.max(max, res);
		}

		return res;
	}

	public static void main(String[] args) {
		int[] a = { -3, 4, -5, -6, 0, -7 };
		MaxProduct res = new MaxProduct();
		System.out.println(res.maxProduct(a));
	}
}
