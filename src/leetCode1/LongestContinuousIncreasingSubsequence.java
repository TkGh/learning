package leetCode1;

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }

        int longest = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                longest = Math.max(count, longest);
                count = 1;
            }
        }

        longest = Math.max(count, longest);

        return longest;
    }
}
