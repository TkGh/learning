package leetCode1;

import java.util.*;

public class RightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Queue<TreeNode> nodes = new LinkedList<>();

		if (root != null) {
			nodes.add(root);
		}

		while (!nodes.isEmpty()) {
			int size = nodes.size();
			int right = 0;
			for (int i = 0; i < size; i++) {
				TreeNode tempNode = nodes.poll();
				right = tempNode.val;
				if (tempNode.left != null) {
					nodes.add(tempNode.left);
				}
				if (tempNode.right != null) {
					nodes.add(tempNode.right);
				}
			}
			res.add(right);
		}

		return res;
	}
}
