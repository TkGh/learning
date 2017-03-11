package leetCode1;

import java.util.*;

/**
 * Given a binary tree, return the preOrder traversal of its nodes' values.
 */
public class PreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		TreeNode prev = null;
		TreeNode curr = root;
		while (curr != null) {
			if (curr.left == null) {
				res.add(curr.val);
				curr = curr.right;
			} else {
				prev = rightButton(curr);
				if (prev.right == null) {
					prev.right = curr;
					res.add(curr.val);
					curr = curr.left;
				}
				if (prev.right == curr) {
					prev.right = null;
					curr = curr.right;
				}
			}
		}

		return res;
	}

	private TreeNode rightButton(TreeNode root) {
		TreeNode prev = root.left;
		while (prev.right != null && prev.right != root) {
			prev = prev.right;
		}
		return prev;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		root.left = a;
		PreorderTraversal res = new PreorderTraversal();
		res.preorderTraversal(root);

	}
}
