package leetCode1;

public class ThirdMax {
	public int thirdMax(int[] nums) {
		int size = nums.length;
		long third = Long.MIN_VALUE;
		int max = nums[0];
		long second = Long.MIN_VALUE;

		for (int i = 0; i < size; i++) {
			if (nums[i] > max) {
				third = second;
				second = max;
				max = nums[i];
			} else if (nums[i] < max && nums[i] > second) {
				third = second;
				second = nums[i];
			} else if (nums[i] > third && nums[i] < second) {
				third = nums[i];
			}

		}

		if (third == second || third == max || Long.MIN_VALUE == third) {
			return max;
		}

		return (int) third;
	}

	public static void main(String[] args) {
		int[] a = {1, 2, 2, 5, 3, 5};// 2
		int[] b = {5, -2, 3, 2, 1};// 2
		int[] c = {1, 2};// 2
		int[] d = {5, 2, 4, 1};// 2
		int[] e = {2, 1, Integer.MIN_VALUE};

		ThirdMax res = new ThirdMax();

		System.out.println(res.thirdMax(a));
		System.out.println(res.thirdMax(b));
		System.out.println(res.thirdMax(c));
		System.out.println(res.thirdMax(d));
		System.out.println(res.thirdMax(e));

	}
}
