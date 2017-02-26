package leetCode1;

public class MaxDepth {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int depth = 1;
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);

		return depth += leftDepth > rightDepth ? leftDepth : rightDepth;
	}
}
