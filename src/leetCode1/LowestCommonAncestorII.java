package leetCode1;

public class LowestCommonAncestorII {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode lowest = helper(root, p, q);
		return lowest;
	}

	private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}

		TreeNode left = helper(root.left, p, q);
		TreeNode right = helper(root.right, p, q);

		if (left == p && right == q) {
			return root;
		}
		if (left == q && right == p) {
			return root;
		}

		if (root == p || root == q) {
			return root;
		}

		if (left != null) {
			return left;
		}

		if (right != null) {
			return right;
		}

		return null;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-1);
		TreeNode a = new TreeNode(0);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(-2);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(8);

		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		c.left = e;

		LowestCommonAncestorII res = new LowestCommonAncestorII();
		System.out.println(res.lowestCommonAncestor(root, e, b).val);
	}
}
