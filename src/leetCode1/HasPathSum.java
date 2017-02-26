package leetCode1;

public class HasPathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null && root.val == sum) {
			return true;
		}

		int num = sum - root.val;
		Boolean l = hasPathSum(root.left, num);
		Boolean r = hasPathSum(root.right, num);

		return l || r;

	}
}
