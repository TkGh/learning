package leetCode1;

public class MaximumGap {
    public int maximumGap(int[] nums) {
        int max = 0;
        if (nums == null || nums.length <= 1) {
            return max;
        }

        int length = nums.length;
        for (int k = length / 2; k >= 1; k--) {
            sink(nums, k, length);
        }
        while (length > 1) {
            exch(nums, 0, length-- - 1);
            sink(nums, 1, length);
            max = Math.max(nums[length] - nums[0], max);
        }


        return max;
    }

    private void sink(int[] nums, int k, int size) {
        while (2 * k <= size) {
            int greater = k * 2;
            if (greater < size && less(nums[greater - 1], nums[greater])) {
                greater++;
            }
            if (less(nums[greater - 1], nums[k - 1])) {
                break;
            }
            exch(nums, k - 1, greater - 1);
            k = greater;
        }

    }

    private boolean less(int var1, int var2) {
        return var1 - var2 < 0 ? true : false;
    }

    private void exch(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 2, 3, 4, 3};
        MaximumGap test = new MaximumGap();
        System.out.println(test.maximumGap(nums));
    }
}
