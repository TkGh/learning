package leetCode1;

import java.util.*;

public class MajorityElement {
	public int majorityElement(int[] nums) {
		int size = nums.length;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < size; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}

		int res = 0;
		for (int i = 0; i < size; i++) {
			if (map.get(nums[i]) > size / 2) {
				res = nums[i];
			}
		}

		return res;

	}

	public static void main(String[] args) {
		int[] a = { 2,11,1,1,1,2,2,2,1,1,1,1};
		MajorityElement b = new MajorityElement();
		System.out.println(b.majorityElement(a));
	}
}
