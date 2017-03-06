package leetCode1;

public class SingleNumber {
	public int SingleNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int res = nums[0];

		for (int i = 1; i < nums.length; i++) {
			res = nums[i] ^ res;
		}

		return res;
	}
}
