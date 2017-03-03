package leetCode1;

import java.util.*;

public class GenerateTrees {
	public List<TreeNode> generateTrees(int n) {
		if (n <= 0) {
			return new ArrayList<>();
		}
		return helper(1, n);
	}

	private List<TreeNode> helper(int start, int end) {
		List<TreeNode> res = new ArrayList<>();
		if (start > end) {
			res.add(null);
			return res;
		}

		for (int i = start; i <= end; i++) {
			List<TreeNode> listLeft = helper(start, i - 1);
			List<TreeNode> listRight = helper(i + 1, end);

			for (int k = 0; k < listLeft.size(); k++) {
				for (int j = 0; j < listRight.size(); j++) {
					TreeNode root = new TreeNode(i);
					root.left = listLeft.get(k);
					root.right = listRight.get(j);
					res.add(root);
				}
			}
		}
		return res;
	}
}
