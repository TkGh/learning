package leetCode1;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        if (n < 1) return 0;

        if (n == 1) return cost[0];

        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }


        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public static void main(String[] args) {
        int[] test = {0, 0, 0, 1};
        System.out.print(new MinCostClimbingStairs().minCostClimbingStairs(test));
    }
}
