package leetCode1;

public class FindMaxConsecutiveOnes {
	public static void main(String[] args) {
		FindMaxConsecutiveOnes test = new FindMaxConsecutiveOnes();
		int[] a = { 1, 1, 0, 1, 1, 1 };
		System.out.println(test.findMaxConsecutiveOnes(a));
	}

	public int findMaxConsecutiveOnes(int[] nums) {
		int size = nums.length;
		int count = 0;
		int res = 0;
		for (int i = 0; i < size; i++) {
			if (nums[i] == 1) {
				count++;
			} else {
				if (count > res) {
					res = count;
				}
				count = 0;
			}
		}

		if (count > res) {
			res = count;
		}

		return res;
	}
}
