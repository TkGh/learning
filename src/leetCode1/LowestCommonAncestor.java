package leetCode1;

public class LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}

		int max = 0;
		int min = 0;

		if (p.val > q.val) {
			max = p.val;
			min = q.val;
		} else {
			max = q.val;
			min = p.val;
		}

		if (root.val <= max && root.val >= min) {
			return root;
		} else if (root.val < min) {
			TreeNode lowest = lowestCommonAncestor(root.right, p, q);
			return lowest;
		} else {
			TreeNode lowest = lowestCommonAncestor(root.left, p, q);
			return lowest;
		}

	}
}
