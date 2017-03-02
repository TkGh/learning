package leetCode1;

public class MaxSubArrayByDandC {
	public int MaxSubArray(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		return helper(nums, 0, nums.length - 1);
	}

	private int helper(int[] nums, int left, int right) {
		if (left >= right) {
			return nums[left];
		}
		int mid = left + (right - left) / 2;
		int lmax = helper(nums, left, mid - 1);
		int rmax = helper(nums, mid + 1, right);
		int mmax = nums[mid], t = mmax;
		for (int i = mid - 1; i >= left; --i) {
			t += nums[i];
			mmax = Math.max(mmax, t);
		}
		t = mmax;
		for (int i = mid + 1; i <= right; ++i) {
			t += nums[i];
			mmax = Math.max(mmax, t);
		}

		return Math.max(mmax, Math.max(lmax, rmax));
	}

	public static void main(String[] args) {
		int[] a = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		MaxSubArrayByDandC b = new MaxSubArrayByDandC();
		System.out.print(b.MaxSubArray(a));
	}

}
