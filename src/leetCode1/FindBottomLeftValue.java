package leetCode1;

import java.util.*;

public class FindBottomLeftValue {
	public int findBottomLeftValue(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		int left = root.val;
		while (!queue.isEmpty()) {
			int size = queue.size();
			TreeNode leftNode = queue.poll();
			left = leftNode.val;
			if (leftNode.left != null) {
				queue.add(leftNode.left);
			}
			if (leftNode.right != null) {
				queue.add(leftNode.right);
			}
			for (int i = 1; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}

		return left;

	}
}
