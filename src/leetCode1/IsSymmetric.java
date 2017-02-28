package leetCode1;

public class IsSymmetric {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right == null) {
			return true;
		}
		TreeNode right = reverse(root.right);

		return isSameTree(root.left, right);

	}

	private TreeNode reverse(TreeNode root) {
		if (root == null) {
			return root;
		}
		if (root.left == null && root.right == null) {
			return root;
		}

		TreeNode tempNode = root.right;
		root.right = root.left;
		root.left = tempNode;

		root.left = reverse(root.left);
		root.right = reverse(root.right);

		return root;
	}

	private boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null) {
			return false;
		}
		if (q == null) {
			return false;
		}

		boolean left = false;
		boolean right = false;
		if (p.val != q.val) {
			return false;
		} else {
			left = isSameTree(p.left, q.left);
			right = isSameTree(p.right, q.right);
		}

		return left && right;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(4);
		TreeNode f = new TreeNode(3);

		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		b.left = e;
		b.right = f;

		IsSymmetric res = new IsSymmetric();
		if (res.isSymmetric(root)) {
			System.out.println(1);
		}
	}
}
