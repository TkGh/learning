package leetCode1;

public class FindMin {
	public int findMin(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}

		int lowest = 1;
		while (lowest < nums.length && nums[lowest] > nums[lowest - 1]) {
			lowest++;
		}

		if (lowest == nums.length) {
			return nums[0];
		}
		return nums[lowest];
	}

	public static void main(String[] args) {
		int[] test = { 4, 1, 2, 3 };
		FindMin res = new FindMin();
		System.out.println(res.findMin(test));
	}
}
