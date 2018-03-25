package leetCode1;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        int cnt = 1;
        int i = 1;
        boolean asc = false;
        for (; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                asc = true;
                cnt++;
                break;
            } else if (nums[i] < nums[i - 1]) {
                asc = false;
                cnt++;
                break;
            }
        }
        if (i == nums.length) return 1;
        int prev = nums[i++];
        for (; i < nums.length; i++) {
            if (asc && nums[i] > prev) {
                prev = nums[i];
            } else if (asc && nums[i] < prev) {
                cnt++;
                prev = nums[i];
                asc = false;
            } else if (!asc && nums[i] < prev) {
                prev = nums[i];
            } else if (!asc && nums[i] > prev) {
                cnt++;
                prev = nums[i];
                asc = true;
            }
        }

        return cnt;
    }


}
