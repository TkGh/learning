package leetCode1;

import java.util.Arrays;

public class FindPairs {
	public int findPairs(int[] nums, int k) {
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return 0;
		}

		Arrays.sort(nums);
		int size = nums.length;
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < size; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				if (nums[j] - k == nums[i]) {
					count++;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		FindPairs res = new FindPairs();
		int[] test = { 3, 1, 3, 3, 3, 5, 4 };
		System.out.println(res.findPairs(test, 2));
	}
}
