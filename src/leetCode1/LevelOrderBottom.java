package leetCode1;

import java.util.*;

public class LevelOrderBottom {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> listTop = new ArrayList<List<Integer>>();
		if (root == null) {
			return listTop;
		}

		helper(root, listTop, 0);

		List<List<Integer>> lists = new ArrayList<List<Integer>>();

		for (int i = 0; i < listTop.size(); i++) {
			lists.add(listTop.get(listTop.size() - 1 - i));
		}
		return lists;
	}

	private void helper(TreeNode root, List<List<Integer>> list, int layer) {
		if (root == null) {
			return;
		}

		if (list.size() > layer) {
			list.get(layer).add(root.val);
		} else {
			List<Integer> array = new ArrayList<Integer>();
			array.add(root.val);
			list.add(array);
		}

		helper(root.left, list, layer + 1);
		helper(root.right, list, layer + 1);
	}
}
