package leetCode1;

public class PathSum {
	public int pathSum(TreeNode root, int sum) {
		int pathNum = 0;
		if (root == null) {
			return pathNum;
		}

		pathNum += helper(root, sum);

		if (root.left != null) {
			pathNum += pathSum(root.left, sum);
		}
		if (root.right != null) {
			pathNum += pathSum(root.right, sum);
		}
		return pathNum;

	}

	private int helper(TreeNode root, int sum) {
		int left = 0;
		int right = 0;
		if (root.left != null) {
			left = helper(root.left, sum - root.val);
		}
		if (root.right != null) {
			right = helper(root.right, sum - root.val);
		}

		if (sum - root.val == 0) {
			return 1 + left + right;

		}
		return left + right;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;

		PathSum a = new PathSum();
		System.out.println(a.pathSum(root, 3));
	}
}
