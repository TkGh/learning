package leetCode1;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 */
public class Flatten {
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}

		TreeNode curr = root;
		while (curr != null) {
			if (curr.left != null) {
				TreeNode rightB = rightButton(curr.left);
				rightB.right = curr.right;
				TreeNode node = curr;
				curr = curr.left;
				node.left = null;
				node.right = curr;
			} else {
				curr = curr.right;
			}
		}
	}

	private TreeNode rightButton(TreeNode root) {
		TreeNode res = root;
		while (res.right != null) {
			res = res.right;
		}

		return res;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(4);
		root.left = a;
		a.right = b;
		b.right = c;

		Flatten res = new Flatten();
		res.flatten(root);
	}
}
