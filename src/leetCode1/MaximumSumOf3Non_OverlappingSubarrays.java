package leetCode1;

public class MaximumSumOf3Non_OverlappingSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] res = new int[3];

        int n = nums.length;
        int[] sum = new int[n + 1];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += nums[i];
            sum[i] = cnt;
        }

        int[][] pos = new int[4][n + 1];
        int[][] dp = new int[4][n + 1];
        for (int l = 1; l < 4; l++) {
            for (int i = k - 1; i < n; i++) {
                int tmpmax = i >= k ? sum[i] - sum[i - k] + dp[l - 1][i - k] : sum[i];
                if (i >= k) {
                    dp[l][i] = dp[l][i - 1];
                    pos[l][i] = pos[l][i - 1];
                }
                if (i > 0 && tmpmax > dp[l][i - 1]) {
                    dp[l][i] = tmpmax;
                    pos[l][i] = i - k + 1;
                }
            }
        }

        res[2] = pos[3][n - 1];
        res[1] = pos[2][res[2] - 1];
        res[0] = pos[1][res[1] - 1];

        return res;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 1, 2, 6, 7, 5, 1};
        int[] res = new MaximumSumOf3Non_OverlappingSubarrays().maxSumOfThreeSubarrays(test, 2);
        for (int n : res) {
            System.out.print(n + " ");
        }
    }
}

/**
 * solution without dp
 */
//class solution{
//     int[] maxSumOfThreeSubarrays(int[] nums, int k) {
//        int[] res = new int[3];
//
//        int n = nums.length;
//        int[] sum = new int[n];
//        int cnt = 0;
//        for (int i = 0; i < n; i++) {
//            cnt += nums[i];
//            sum[i] = cnt;
//        }
//
//        int max = 0;
//        for (int i = k; i <= n - 2 * k; i++) {
//            int left = 0;
//            int indexl = 0;
//            for (int l = 0; l <= i - k; l++) {
//                if (l > 0) {
//                    if (sum[l + k - 1] - sum[l - 1] > left) {
//                        left = sum[l + k - 1] - sum[l - 1];
//                        indexl = l;
//                    }
//                } else {
//                    if (sum[l + k - 1] > left) {
//                        left = sum[l + k - 1];
//                        indexl = 0;
//                    }
//                }
//            }
//
//            int right = 0;
//            int indexr = 0;
//            for (int r = i + k; r <= n - k; r++) {
//                if (sum[r + k - 1] - sum[r - 1] > right) {
//                    right = sum[r + k - 1] - sum[r - 1];
//                    indexr = r;
//                }
//            }
//
//            if (left + right + sum[i + k - 1] - sum[i - 1] > max) {
//                res[0] = indexl;
//                res[1] = i;
//                res[2] = indexr;
//                max = left + right + sum[i + k - 1] - sum[i - 1];
//            }
//        }
//
//        return res;
//    }
//}
