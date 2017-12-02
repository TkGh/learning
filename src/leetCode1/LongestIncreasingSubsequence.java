package leetCode1;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }

        int max = 0;
        int[] cnt = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int tmp = -1;
            while (j >= 0) {
                if (nums[i] > nums[j]) {
                    tmp = Math.max(tmp, cnt[j]);
                }
                j--;
            }
            cnt[i] = tmp == -1 ? 0 : tmp + 1;
            max = Math.max(max, cnt[i]);
        }

        return max + 1;
    }

    public static void main(String[] args) {
        int[] test = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.print(new LongestIncreasingSubsequence().lengthOfLIS(test));
    }
}
