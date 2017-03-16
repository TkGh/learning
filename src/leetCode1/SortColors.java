package leetCode1;

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 */
public class SortColors {
	public void sortColors(int[] nums) {
		if (nums == null && nums.length <= 1) {
			return;
		}

		sortHelper(nums, 0, nums.length - 1);
	}

	private void sortHelper(int[] nums, int low, int high) {
		if (high <= low) {
			return;
		}

		int lt = low;
		int gt = high;
		int i = low + 1;
		int v = nums[low];

		while (i <= gt) {
			if (nums[i] < v) {
				exch(nums, i++, lt++);
			} else if (nums[i] > v) {
				exch(nums, i, gt--);
			} else {
				i++;
			}
		}

		sortHelper(nums, low, lt - 1);
		sortHelper(nums, gt + 1, high);
	}

	private void exch(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		int[] test = { 0, 1, 1, 2, 1, 1, 2, 0, 0, 1, 0, 2, 2, 2, 2 };
		SortColors res = new SortColors();
		res.sortColors(test);
		for (int e : test) {
			System.out.print(e + "  ");
		}
	}
}
