package leetCode1;

import java.util.*;

public class SortedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}

		List<Integer> arr = new ArrayList<Integer>();
		ListNode curr = head;
		while (curr != null) {
			arr.add(curr.val);
			curr = curr.next;
		}

		int[] nums = new int[arr.size()];

		for (int i = 0; i < arr.size(); i++) {
			nums[i] = arr.get(i);
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
