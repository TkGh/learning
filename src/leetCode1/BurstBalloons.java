package leetCode1;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if (n < 1) return 0;

        //Create a new array, which add 1 at each end:
        int[] padding = new int[n += 2];
        int index = 1;
        for (int num : nums) {
            padding[index++] = num;
        }
        padding[0] = 1;
        padding[index] = 1;

        int[][] dp = new int[n][n];
        for (int Len = 2; Len < n; Len++) {
            for (int i = 0; i < n - Len; i++) {
                int j = i + Len;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], padding[i] * padding[k] * padding[j] + dp[i][k] + dp[k][j]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
