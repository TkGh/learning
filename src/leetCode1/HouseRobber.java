package leetCode1;

public class HouseRobber {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int even = 0;
		int odd = 0;

		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0) {
				even = Math.max(even + nums[i], odd);
			}
			if (i % 2 == 1) {
				odd = Math.max(odd + nums[i], even);
			}
		}

		return Math.max(even, odd);
	}

	public static void main(String[] args) {
		int[] test = { 2, 1, 1, 2 };
		HouseRobber res = new HouseRobber();
		System.out.println(res.rob(test));
	}
}
