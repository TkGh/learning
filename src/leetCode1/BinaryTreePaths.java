package leetCode1;

import java.util.*;

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> path = new ArrayList<String>();
		if (root == null) {
			return path;
		}

		path = helper(root);

		return path;
	}

	private List<String> helper(TreeNode root) {
		Integer val = root.val;

		if (root.left == null && root.right == null) {
			List<String> path = new ArrayList<String>();
			path.add(val.toString());
			return path;
		}

		if (root.right == null) {
			List<String> path = helper(root.left);
			for (int i = 0; i < path.size(); i++) {
				path.set(i, val.toString() + "->" + path.get(i));
			}

			return path;
		}

		if (root.left == null) {
			List<String> path = helper(root.right);
			for (int i = 0; i < path.size(); i++) {
				path.set(i, val.toString() + "->" + path.get(i));
			}

			return path;
		}

		List<String> path = helper(root.left);
		List<String> right = helper(root.right);
		for (int i = 0; i < right.size(); i++) {
			path.add(right.get(i));
		}

		for (int i = 0; i < path.size(); i++) {
			path.set(i, val.toString() + "->" + path.get(i));
		}

		return path;
	}
}
