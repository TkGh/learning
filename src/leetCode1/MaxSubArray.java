package leetCode1;

public class MaxSubArray {
	public int maxSubArray(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}

		int sum = Integer.MIN_VALUE;
		int tempSum = 0;

		for (int num : nums) {
			tempSum = Math.max(tempSum + num, num);
			sum = Math.max(sum, tempSum);
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] a = { -2, -1 };
		MaxSubArray b = new MaxSubArray();
		System.out.print(b.maxSubArray(a));
	}
}
