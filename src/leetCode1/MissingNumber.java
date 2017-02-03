package leetCode1;

public class MissingNumber {
	public int missingNumber(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int size = nums.length;
		int count = size;
		for (int i = 0; i < size; i++) {
			int temp = i - nums[i];
			count += temp;
		}

		return count;
	}

	public static void main(String[] args) {
		int[] a = { 0,1,2,3,4,5,6,7 };
		MissingNumber b = new MissingNumber();
		System.out.println(b.missingNumber(a));
	}
}
