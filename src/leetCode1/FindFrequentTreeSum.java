package leetCode1;

import java.util.*;

public class FindFrequentTreeSum {
	public int[] findFrequentTreeSum(TreeNode root) {
		if (root == null) {
			return new int[0];
		}

		HashMap<Integer, Integer> map = new HashMap<>();
		helper(root, map);

		int max = Integer.MIN_VALUE;
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			int value = (int) entry.getValue();
			if (value > max) {
				max = value;
			}
		}

		iter = map.entrySet().iterator();
		List<Integer> res = new ArrayList<>();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			if ((int) entry.getValue() == max) {
				res.add((int) entry.getKey());
			}
		}
		int[] sums = new int[res.size()];
		for (int i = 0; i < sums.length; i++) {
			sums[i] = res.get(i);
		}

		return sums;
	}

	private int helper(TreeNode root, HashMap<Integer, Integer> map) {
		if (root == null) {
			return 0;
		}

		int left = 0;
		int right = 0;
		left = helper(root.left, map);
		right = helper(root.right, map);

		int value = left + right + root.val;
		if (map.containsKey(value)) {
			map.put(value, map.get(value) + 1);
		} else {
			map.put(value, 1);
		}

		return value;
	}
}
