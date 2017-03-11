package leetCode1;

/**
 * Given inOrder and postOrder traversal of a tree, construct the binary tree.
 * Note: You may assume that duplicates do not exist in the tree.
 */
public class BuildTreeFromPostNIn {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || inorder.length == 0) {
			return null;
		}

		TreeNode root = helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
		return root;
	}

	private TreeNode helper(int[] inorder, int[] postorder, int startI, int endI, int startP, int endP) {
		if (startI > endI || startP > endP) {
			return null;
		}

		TreeNode root = new TreeNode(postorder[endP]);

		int rootInIn = find(inorder, startI, endI, postorder[endP]);

		root.left = helper(inorder, postorder, startI, rootInIn - 1, startP, endP - (endI - rootInIn) - 1);
		root.right = helper(inorder, postorder, rootInIn + 1, endI, endP - (endI - rootInIn), endP - 1);

		return root;
	}

	/**
	 * @param target
	 *            the goal
	 * @return res position in array
	 */
	private int find(int[] nums, int start, int end, int target) {
		int res = -1;
		for (int i = start; i <= end; i++) {
			if (nums[i] == target) {
				res = i;
				break;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] in = { 2, 3, 1, 7, 5, 8, 4, 6 };
		int[] post = { 3, 2, 7, 8, 5, 6, 4, 1 };
		BuildTreeFromPostNIn test = new BuildTreeFromPostNIn();

		test.buildTree(in, post);

	}
}
