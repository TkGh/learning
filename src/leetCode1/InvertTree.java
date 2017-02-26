package leetCode1;

public class InvertTree {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}

		return helper(root);
	}

	private TreeNode helper(TreeNode root) {
		if (root.left == null && root.right == null) {
			return root;
		}

		TreeNode temp = root.right;
		root.right = root.left;
		root.left = temp;

		if (root.left != null) {
			root.left = helper(root.left);
		}
		if (root.right != null) {
			root.right = helper(root.right);
		}

		return root;
	}
}
