package leetCode1;

public class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();

        if (n < 1) return 0;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (Integer.valueOf(s.substring(i - 1, i)) >= 1) {
                dp[i] += i == 1 ? 1 : dp[i - 1];
            }
            if (i >= 2 && Integer.valueOf(s.substring(i - 2, i - 1)) != 0
                    && Integer.valueOf(s.substring(i - 2, i)) <= 26 && Integer.valueOf(s
                    .substring(i - 2, i)) >= 1) {
                dp[i] += i == 2 ? 1 : dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.print(new DecodeWays().numDecodings("01"));
    }
}
