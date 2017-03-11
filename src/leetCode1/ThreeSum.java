package leetCode1;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length <= 2) {
			return res;
		}

		Arrays.sort(nums);

		for (int i = nums.length - 1; i > 1; i--) {
			if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
				continue;
			}
			List<List<Integer>> twoRes = twoSum(nums, i - 1, -nums[i]);
			for (int j = 0; j < twoRes.size(); j++) {
				twoRes.get(j).add(nums[i]);
			}
			res.addAll(twoRes);
		}

		return res;
	}

	private List<List<Integer>> twoSum(int[] nums, int end, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length <= 1 || end < 1) {
			return res;
		}

		int left = 0;
		int right = end;
		while (left < right) {
			if (nums[left] + nums[right] == target) {
				List<Integer> path = new ArrayList<>();
				path.add(nums[left]);
				path.add(nums[right]);
				res.add(path);
				left++;
				right--;
				while (left < right && nums[left] == nums[left - 1]) {
					left++;
				}
				while (left < right && nums[right] == nums[right + 1]) {
					right--;
				}
			} else if (nums[left] + nums[right] > target) {
				right--;
			} else {
				left++;
			}
		}

		return res;

	}

	public static void main(String[] args) {
		int[] test = { -1, 0, 1, 2, -1, -4 };
		ThreeSum res = new ThreeSum();
		res.threeSum(test);
	}
}
