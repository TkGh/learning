package leetCode1;

import java.util.*;

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<String>();
		if (root.val == 0) {
			return paths;
		}
		if (root.left == null && root.right == null) {
			paths.add("root.val");
			return paths;
		}

		return paths;
	}
}
