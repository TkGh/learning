package leetCode1;

import java.util.*;

public class FindMode {
	public int[] findMode(TreeNode root) {
		if (root == null) {
			return new int[0];
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int count = helper(root, map);
		List<Integer> res = new ArrayList<Integer>();
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Integer key = (Integer) entry.getKey();
			Integer value = (Integer) entry.getValue();
			if (value == count) {
				res.add(key);
			}
		}
		int[] mode = new int[res.size()];
		for (int i = 0; i < mode.length; i++) {
			mode[i] = res.get(i);
		}

		return mode;

	}

	private int helper(TreeNode root, HashMap<Integer, Integer> map) {
		if (map.containsKey(root.val)) {
			map.put(root.val, map.get(root.val) + 1);
		} else {
			map.put(root.val, 1);
		}

		int left = 0;
		int right = 0;
		if (root.left != null) {
			left = helper(root.left, map);
		}

		if (root.right != null) {
			right = helper(root.right, map);
		}

		return Math.max(map.get(root.val), Math.max(left, right));
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2147483647);
		FindMode test = new FindMode();
		int[] res = test.findMode(root);
		for (int e : res) {
			System.out.println(e);
		}
	}

}
