package leetCode1;

public class SortedArrayToBS {
	public TreeNode sortedArrayToBS(int[] nums) {
		if (nums.length == 0) {
			return null;
		}

		TreeNode root = helper(nums, 0, nums.length - 1);

		return root;
	}

	private TreeNode helper(int[] nums, int left, int right) {
		int mid = left + (right - left) / 2;
		TreeNode root = new TreeNode(nums[mid]);

		if (left == right) {
			return root;
		}

		if (mid == left) {
			root.right = helper(nums, right, right);
			return root;
		}

		root.left = helper(nums, left, mid - 1);
		root.right = helper(nums, mid + 1, right);

		return root;

	}
}
