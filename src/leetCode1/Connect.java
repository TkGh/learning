package leetCode1;

public class Connect {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		helperFB(root);
		helperFT(root);
	}

	private void helperFB(TreeLinkNode root) {
		if (root.left == null) {
			return;
		}

		root.left.next = root.right;
		helperFB(root.left);
		helperFB(root.right);
	}

	private void helperFT(TreeLinkNode root) {
		if (root.left == null) {
			return;
		}

		if (root.next != null) {
			root.right.next = root.next.left;
		} else {
			root.right.next = null;
		}

		helperFT(root.left);
		helperFT(root.right);
	}

}
