package leetCode1;

public class IsSameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
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
}
