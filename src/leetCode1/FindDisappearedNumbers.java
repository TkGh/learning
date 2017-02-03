package leetCode1;

import java.util.*;

public class FindDisappearedNumbers {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		ArrayList<Integer> res = new ArrayList<Integer>(nums.length);
		int size = nums.length;
		for (int i = 0; i < size; i++) {
			int temp = Math.abs(nums[i]);
			temp -= 1;
			if (nums[temp] > 0) {
				nums[temp] = -nums[temp];
			}
		}

		for (int i = 0; i < size; i++) {
			if (nums[i] > 0) {
				res.add(i + 1);
			}
		}
		return res;

	}
}
