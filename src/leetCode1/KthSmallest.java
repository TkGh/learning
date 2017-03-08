package leetCode1;

import java.util.*;

public class KthSmallest {
	public int kthSmallest(TreeNode root, int k) {
		List<Integer> res = new ArrayList<>(1);
		helper(root, k, res);

		return res.get(0);

	}

	private int helper(TreeNode root, int k, List<Integer> target) {
		if (root == null) {
			return 0;
		}

		int left = helper(root.left, k, target);
		if (left + 1 == k) {
			target.add(root.val);

		}
		int right = helper(root.right, k - left - 1, target);

		return left + right + 1;
	}
}
