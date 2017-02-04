package leetCode1;

import java.util.*;

public class ContainsNearbyDuplicate {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums.length == 0 || nums.length == 1) {
			return false;
		}

		HashMap<Integer, Integer> comp = new HashMap<Integer, Integer>();
		int size = nums.length;
		for (int i = 0; i < size; i++) {
			if (comp.containsKey(nums[i])) {
				int j = comp.get(nums[i]);
				if (i - j <= k) {
					return true;
				}
			}

			comp.put(nums[i], i);

		}

		return false;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 1, 1, 7, 8, 1 };
		ContainsNearbyDuplicate b = new ContainsNearbyDuplicate();
		System.out.println(b.containsNearbyDuplicate(a, 2));
	}
}
