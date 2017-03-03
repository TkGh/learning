package leetCode1;

import java.util.*;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * @author machen
 *
 */
public class PathSum2 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();

		if (root == null) {
			return res;
		}

		helper(root, path, res, sum);

		return res;
	}

	private void helper(TreeNode root, List<Integer> path, List<List<Integer>> paths, int sum) {
		if (root == null) {
			return;
		}

		if (sum - root.val == 0 && root.left == null && root.right == null) {
			path.add(root.val);
			paths.add(new ArrayList<>(path));
			path.remove(path.size() - 1);
			return;
		}

		path.add(root.val);
		helper(root.left, path, paths, sum - root.val);
		helper(root.right, path, paths, sum - root.val);
		path.remove(path.size() - 1);
	}

	public static void main(String[] args) {
		// TreeNode root = new TreeNode(-2);
		// TreeNode a = new TreeNode(-3);
		//
		// root.left = a;
		//
		// PathSum2 res = new PathSum2();
	}
}
