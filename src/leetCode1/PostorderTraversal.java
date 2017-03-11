package leetCode1;

import java.util.*;

/**
 * Given a binary tree, return the postOrder traversal of its nodes' values.
 */
public class PostorderTraversal {
	public List<Integer> postTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		TreeNode prev = null;
		TreeNode dump = new TreeNode(0);
		dump.left = root;
		TreeNode curr = dump;

		while (curr != null) {
			if (curr.left == null) {
				curr = curr.right;
			} else {
				prev = findPredecessor(curr);
				if (prev.right == null) {
					prev.right = curr;
					curr = curr.left;
				}
				if (prev.right == curr) {
					prev.right = null;
					export(prev, curr.left, res);
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

	private void export(TreeNode start, TreeNode end, List<Integer> res) {
		Stack<Integer> stack = new Stack<>();
		TreeNode curr = end;
		while (curr != start) {
			stack.push(curr.val);
			curr = curr.right;
		}
		stack.push(start.val);

		while (!stack.isEmpty()) {
			res.add(stack.pop());
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		root.right = right;
		PostorderTraversal res = new PostorderTraversal();
		res.postTraversal(root);
	}
}
