package leetCode1;

public class ConnectII {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}

		TreeLinkNode dummy = new TreeLinkNode(0);
		for (TreeLinkNode curr = root, prev = dummy; curr != null; curr = curr.next) {
			if (curr.left != null) {
				prev.next = curr.left;
				prev = prev.next;
			}
			if (curr.right != null) {
				prev.next = curr.right;
				prev = prev.next;
			}
		}

		connect(dummy.next);
	}
}
