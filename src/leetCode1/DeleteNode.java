package leetCode1;

public class DeleteNode {
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return root;
		}

		if (root.val > key) {
			root.left = deleteNode(root.left, key);
		} else if (root.val < key) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.left != null && root.right != null) {
				root.val = findMin(root.right).val;
				root.right = deleteNode(root.right, root.val);
			} else {
				if (root.left == null) {
					root = root.right;
				} else {
					root = root.left;
				}
			}
		}
		return root;

	}

	private TreeNode findMin(TreeNode root) {
		TreeNode node = root;
		while (node != null) {
			node = node.left;
		}
		return node;
	}

}
