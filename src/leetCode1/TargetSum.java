package leetCode1;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (Math.abs(S) > sum || (S + sum) % 2 > 0) return 0;

        int tar = (S + sum) / 2;
        int[] dp = new int[tar + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = tar; i > n; i--) {
                dp[i] += dp[i - n];
            }
        }


        return dp[tar];
    }

    public static void main(String[] args) {
        int[] test = {1, 1, 1, 1, 1};
        System.out.print(new TargetSum().findTargetSumWays(test, 3));
    }
}
