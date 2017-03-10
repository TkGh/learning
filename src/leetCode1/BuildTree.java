package leetCode1;

/**
 * Given preOrder and inOrder traversal of a tree, construct the binary tree.
 * Note: You may assume that duplicates do not exist in the tree.
 */
public class BuildTree {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0) {
			return null;
		}

		TreeNode root = helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
		return root;
	}

	private TreeNode helper(int[] preorder, int[] inorder, int startP, int endP, int startI, int endI) {
		if (startP > endP || startI > endI) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[startP]);

		int rootInInorder = find(inorder, startI, endI, preorder[startP]);

		root.left = helper(preorder, inorder, startP + 1, startP + (rootInInorder - startI), startI, rootInInorder - 1);
		root.right = helper(preorder, inorder, startP + (rootInInorder - startI) + 1, endP, rootInInorder + 1, endI);

		return root;
	}

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
		int[] pre = { 1, 2, 3, 4, 5, 7, 8, 6 };
		int[] in = { 2, 3, 1, 7, 5, 8, 4, 6 };
		BuildTree res = new BuildTree();
		res.buildTree(pre, in);

	}
}
