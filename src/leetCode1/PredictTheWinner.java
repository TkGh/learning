package leetCode1;

/**
 * Space complex(n) ver
 */
public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        int size = nums.length;

        int[] dp = new int[size];
        dp[size - 1] = nums[size - 1];

        for (int len = 1; len < size; len++) {
            dp[size - len - 1] = nums[size - len - 1];
            for (int i = size - len; i < size; i++) {
                dp[i] = Math.max(nums[size - len - 1] - dp[i], nums[i] - dp[i - 1]);
            }
        }

        return dp[size - 1] >= 0;
    }
}

/**
 * Space complex(n^2) ver
 */
//class Solution {
//    public boolean PredictTheWinner(int[] nums) {
//        int size = nums.length;
//
//        int[][] dp = new int[size][size];
//        for (int i = 0; i < size; i++) {
//            dp[i][i] = nums[i];
//        }
//
//        int len = 1;
//        for (; len < size; len++) {
//            for (int i = 0; i < size - len; i++) {
//                int j = i + len;
//                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
//            }
//        }
//
//        return dp[0][size - 1] >= 0;
//    }
//}