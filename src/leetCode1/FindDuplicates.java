package leetCode1;

import java.util.*;

public class FindDuplicates {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums.length == 0 || nums.length == 1) {
			return res;
		}

		int size = nums.length;
		for (int i = 0; i < size; i++) {
			int temp = Math.abs(nums[i]) - 1;
			if (nums[temp] > 0) {
				nums[temp] = -nums[temp];
			}
		}
		for (int i = 0; i < size; i++) {
			int temp = Math.abs(nums[i]) - 1;
			nums[temp] = -nums[temp];

		}

		for (int i = 0; i < size; i++) {
			if (nums[i] < 0) {
				res.add(i + 1);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] a = { 1,1, 4, 3, 2, 7, 8, 2, 3, 7, 8 ,12};
		FindDuplicates b = new FindDuplicates();
		int[] res = new int[b.findDuplicates(a).size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = b.findDuplicates(a).get(i);
		}

		for (int e : res) {
			System.out.println(e);
		}
	}
}
