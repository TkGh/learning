package leetCode1;

public class LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) return 0;

        int res = 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= max * 2) {
                res = i;
                max = nums[i];
            } else if (nums[i] > max) {
                res = -1;
                max = nums[i];
            } else if (max < nums[i] * 2) {
                res = -1;
            }
        }

        return res;
    }
}
