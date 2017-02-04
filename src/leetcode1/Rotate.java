package leetCode1;

public class Rotate {
	public void rotate(int[] nums, int k) {
		int size = nums.length;

		if (k % size != 0) {

			while (k > size) {
				k -= size;
			}
			// reverse 0 to size-k-1
			int i = 0;
			int j = size - k - 1;
			while (i < j) {
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				i++;
				j--;
			}

			// reverse size-k to size
			i = size - k;
			j = size - 1;
			while (i < j) {
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				i++;
				j--;
			}

			// reverse the whole array
			i = 0;
			j = size - 1;
			while (i < j) {
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				i++;
				j--;
			}
		}

		for (int e : nums) {
			System.out.print(e);
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6 };
		Rotate b = new Rotate();
		b.rotate(a, 3);
	}
}
