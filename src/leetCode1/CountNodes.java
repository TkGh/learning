package leetCode1;

public class CountNodes {
	public int countNodes(TreeNode root) {
		int res = 0;
		if (root == null) {
			return res;
		}

		int left = getLeftHeight(root) + 1;
		int right = getRightHeight(root) + 1;

		if (left == right) {
			return (2 << (left - 1)) - 1;
		} else {
			return countNodes(root.left) + countNodes(root.right) + 1;
		}
	}

	private int getLeftHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int count = 0;
		while (root.left != null) {
			count++;
			root = root.left;
		}

		return count;
	}

	private int getRightHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int count = 0;
		while (root.right != null) {
			count++;
			root = root.right;
		}

		return count;
	}
}
