package leetCode1;

public class MinSubArrayLen {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			if (nums[0] >= s) {
				return 1;
			} else {
				return 0;
			}
		}

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum < s) {
			return 0;
		}

		int size = nums.length;
		int minLens = Integer.MAX_VALUE;
		sum = 0;
		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				sum += nums[j];
				if (sum >= s) {
					minLens = Math.min(minLens, j - i + 1);
					break;
				}
			}
			sum = 0;
		}

		return minLens;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		MinSubArrayLen b = new MinSubArrayLen();
		System.out.println(b.minSubArrayLen(11, a));
	}
}
