package leetCode1;

public class SearchInsert {
	public int searchInsert(int[] nums, int target) {
		int size = nums.length;

		if (nums.length == 0) {
			return 0;
		}
		if (nums[size - 1] < target) {
			return size;
		}

		int pos = 0;

		for (int i = 0; i < size; i++) {
			if (nums[i] >= target) {
				pos++;
				break;
			} else {
				pos++;
			}
		}

		return pos - 1;
	}

	public static void main(String[] args) {
		int[] a = { 10};
		SearchInsert b = new SearchInsert();
		System.out.print(b.searchInsert(a, 5));
		System.out.print(b.searchInsert(a, 2));
		System.out.print(b.searchInsert(a, 7));
		System.out.print(b.searchInsert(a, 0));
	}
}
