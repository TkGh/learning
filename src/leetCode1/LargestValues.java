package leetCode1;

import java.util.*;

public class LargestValues {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();

		if (root != null) {
			queue.add(root);
		}

		while (!queue.isEmpty()) {
			int size = queue.size();
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				max = Math.max(max, node.val);

				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			res.add(max);
		}

		return res;
	}

	public static void main(String[] args) {
		LargestValues res = new LargestValues();
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode d = new TreeNode(3);
		TreeNode c = new TreeNode(5);
		root.left = a;
		a.left = b;
		a.right = d;
		b.left = c;
		res.largestValues(root);
	}
}
