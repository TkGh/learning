package leetCode1;

public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		if (nums.length == 0 || nums.length == 1) {
			return 0;
		}

		int low = 0;
		int size = nums.length;
		int high = size - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			if (nums[mid] < nums[mid + 1]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		return low;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 2, 1, 2, 5, 1 };
		FindPeakElement b = new FindPeakElement();
		System.out.println(b.findPeakElement(a));
	}
}
