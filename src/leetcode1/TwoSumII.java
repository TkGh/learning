package leetCode1;

import java.util.*;

public class TwoSumII {
	public int[] twoSum(int[] numbers, int target) {
		int size = numbers.length;
		HashMap<Integer, Integer> map = new HashMap<>();

		int[] res = new int[2];
		for (int i = 0; i < size; i++) {
			map.put(numbers[i], i);
		}

		for (int i = 0; i < size; i++) {
			int j = target - numbers[i];
			if (map.containsKey(j)) {
				if (map.get(j) != i) {
					res[0] = i + 1;
					res[1] = map.get(j) + 1;
					break;
				} else {
					continue;
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 7, 4, 5, 222 };
		TwoSumII b = new TwoSumII();
		int[] c = b.twoSum(a, 229);
		for (int e : c) {
			System.out.println(e);
		}
	}
}
