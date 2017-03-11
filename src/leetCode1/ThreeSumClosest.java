package leetCode1;

import java.util.*;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length <= 2) {
			return 0;
		}
		int res = 0;
		int tempMin = Integer.MAX_VALUE;

		Arrays.sort(nums);
		for (int i = nums.length - 1; i > 1; i--) {
			if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
				continue;
			}
			int tempRes = minTwo(nums, target - nums[i], i - 1) + nums[i];
			if (Math.abs(tempRes - target) < tempMin) {
				tempMin = Math.abs(tempRes - target);
				res = tempRes;
			}
		}

		return res;
	}

	private int minTwo(int[] nums, int target, int end) {
		if (nums == null || nums.length <= 1) {
			return Integer.MAX_VALUE;
		}

		int res = 0;
		int tempMin = Integer.MAX_VALUE;
		for (int right = end; right > 0; right--) {
			if (right < end && nums[right] == nums[right + 1]) {
				continue;
			}
			for (int left = 0; left < right; left++) {
				if (left > 0 && nums[left] == nums[left - 1]) {
					continue;
				}
				if (Math.abs(nums[left] + nums[right] - target) < tempMin) {
					tempMin = Math.abs(nums[left] + nums[right] - target);
					res = nums[left] + nums[right];
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		ThreeSumClosest test = new ThreeSumClosest();
		int[] res = { -1, 2, 1, -4 };
		System.out.println(test.threeSumClosest(res, 1));
	}
}
