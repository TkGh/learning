package leetCode1;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;

        if (n < 1) return 0;

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i] += i >= nums[j - 1] ? dp[i - nums[j - 1]] : 0;
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3};
        System.out.print(new CombinationSumIV().combinationSum4(test, 4));
    }
}
