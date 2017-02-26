package leetCode1;

public class MinDepth {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null && root != null) {
			return 1;
		}

		if (root.left == null) {
			return minDepth(root.right) + 1;
		}
		if (root.right == null) {
			return minDepth(root.left) + 1;
		}
		int Depth = 1;
		int left = minDepth(root.left);
		int right = minDepth(root.right);

		return Depth += left < right ? left : right;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode a = new TreeNode(0);
		root.left = a;

		MinDepth res = new MinDepth();
		System.out.println(res.minDepth(root));
	}
}
