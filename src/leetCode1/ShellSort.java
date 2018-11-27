package leetCode1;

public class ShellSort {
    private void sort(int[] nums) {
        int h = 1;

        while (h < nums.length / 3) h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < nums.length; i++) {
                for (int j = i; j >= h && nums[j] < nums[j - h]; j -= h) {
                    exch(nums, j, j - h);
                }
            }
            h /= 3;
        }
    }

    private void exch(int[] nums, int i, int j) {
        int tmp;
        tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
