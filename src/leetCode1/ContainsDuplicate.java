package leetCode1;

import java.util.*;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		if (nums.length == 0 || nums.length == 1) {
			return false;
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int size = nums.length;
		for (int i = 0; i < size; i++) {
			if (map.containsKey(nums[i])) {
				return true;
			} else {
				map.put(nums[i], 1);
			}
		}

		return false;

	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 ,1};
		ContainsDuplicate b = new ContainsDuplicate();
		System.out.println(b.containsDuplicate(a));
	}
}
