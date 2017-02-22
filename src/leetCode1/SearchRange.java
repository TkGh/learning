package leetCode1;

public class SearchRange {
	public int[] searchRange(int[] nums, int target) {
		int[] pos = new int[2];

		if (nums.length == 0) {
			pos[0] = -1;
			pos[1] = -1;
			return pos;
		}

		if (nums[0] > target || nums[nums.length - 1] < target) {
			pos[0] = -1;
			pos[1] = -1;
			return pos;
		}

		// get the left frontier
		int size = nums.length;
		int left = 0;
		int right = size - 1;
		while (left <= right) {
			if (nums[left] == target) {
				break;
			}
			if (nums[left] > target) {
				left = -1;
				break;
			}
			int mid = (left + right) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		pos[0] = left;

		// get the right frontier
		left = 0;
		right = size - 1;
		while (left <= right) {
			if (nums[right] == target) {
				break;
			}
			if (nums[right] < target) {
				right = -1;
				break;
			}
			int mid = (left + right + 1) / 2;
			if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid;
			}
		}
		pos[1] = right;

		return pos;

	}

	public static void main(String[] args) {
		int[] a = { 1,5,5,6,7,8 };
		SearchRange b = new SearchRange();
		int[] c = new int[2];
		c = b.searchRange(a, 5);
		for (int e : c) {
			System.out.println(e);
		}
	}
}
