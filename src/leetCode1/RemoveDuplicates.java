package leetCode1;

public class RemoveDuplicates {
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0 || nums.length == 1) {
			return nums.length;
		}

		int size = nums.length;
		int index = 0;
		for (int i = 0; i < size; i++) {
			if (nums[index] != nums[i]) {
				nums[index + 1] = nums[i];
				index++;
			}
		}

		return index + 1;
	}

	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 2, 2, 2, 3, 4, 5 };
		RemoveDuplicates b = new RemoveDuplicates();
		System.out.print(b.removeDuplicates(a));
	}
}
