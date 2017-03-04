package leetCode1;

import java.util.*;

public class ZigzagLevelOrder {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		if (root != null) {
			stack.add(root);
		}

		int level = 1;
		while (!stack.isEmpty()) {
			int size = stack.size();
			List<Integer> path = new ArrayList<>();
			Stack<TreeNode> tempStack = new Stack<>();
			for (int i = size - 1; i >= 0; i--) {
				TreeNode node = stack.pop();
				if (level % 2 == 1) {
					if (node.left != null) {
						tempStack.add(node.left);
					}
					if (node.right != null) {
						tempStack.add(node.right);
					}

				} else if (level % 2 == 0) {
					if (node.right != null) {
						tempStack.add(node.right);
					}
					if (node.left != null) {
						tempStack.add(node.left);
					}
				}
				path.add(node.val);
			}
			stack = tempStack;
			level++;
			res.add(path);
		}
		return res;
	}

}
