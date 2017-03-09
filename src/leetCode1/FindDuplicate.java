package leetCode1;

public class FindDuplicate {
	public int findDuplicate(int[] nums) {
		int fast = 0;
		int slow = 0;

		do {
			fast = nums[nums[fast]];
			slow = nums[slow];
		} while (fast != slow);

		slow = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}

	public static void main(String[] args) {
		FindDuplicate res = new FindDuplicate();
		int[] test = { 3, 3, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(res.findDuplicate(test));
	}
}
