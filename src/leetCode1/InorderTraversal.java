package leetCode1;

import java.util.*;

public class InorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		// morris algorithm

		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		TreeNode curr = root;
		TreeNode prev = null;
		while (curr != null) {
			if (curr.left == null) {
				res.add(curr.val);
				curr = curr.right;
			} else {
				prev = findPredecessor(curr);
				if (prev.right == null) {
					prev.right = curr;
					curr = curr.left;
				}
				if (prev.right == curr) {
					prev.right = null;
					res.add(curr.val);
					curr = curr.right;
				}
			}
		}

		return res;
	}

	private TreeNode findPredecessor(TreeNode root) {
		TreeNode prev = root.left;
		while (prev.right != null && prev.right != root) {
			prev = prev.right;
		}

		return prev;
	}

	public static void main(String[] args) {
		InorderTraversal res = new InorderTraversal();
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		root.right = a;
		a.left = b;

		res.inorderTraversal(root);
	}
}
