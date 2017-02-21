package leetCode1;

public class SumOfLeftLeaves {
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int sum = 0;
		if (root.left != null) {
			if (root.left.left == null && root.left.right == null) {
				sum += root.left.val;
			}
		}
		int left = sumOfLeftLeaves(root.left);
		int right = sumOfLeftLeaves(root.right);

		return sum + left + right;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode a = new TreeNode(9);
		TreeNode b = new TreeNode(20);
		TreeNode c = new TreeNode(15);
		TreeNode d = new TreeNode(7);

		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;

		SumOfLeftLeaves e = new SumOfLeftLeaves();
		System.out.println(e.sumOfLeftLeaves(root));
	}
}
