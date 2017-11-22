package leetCode1;

public class Non_decreasingArray {
    public boolean checkPossibility(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return true;
        }

        for (int i = 1; i < length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (i > 1) {
                    if (nums[i - 2] > nums[i]) {
                        nums[i] = nums[i - 1];
                        return helper(nums, i);
                    } else {
                        nums[i - 1] = nums[i - 2];
                        return helper(nums, i - 1);
                    }
                } else {
                    return helper(nums, i);
                }
            }
        }

        return true;
    }

    private boolean helper(int[] nums, int i) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] < nums[j - 1]) {
                return false;
            }
        }

        return true;
    }
}
