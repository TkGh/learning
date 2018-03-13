package leetCode1;

public class RotatedDigits {
    public int rotatedDigits(int N) {
        int i;
        int dp[] = new int[N + 1];
        int cnt = 0;
        int hi, lo;
        for (i = 0; i <= N; i++) {
            if (i < 10) {
                if (i == 0 || i == 1 || i == 8) dp[i] = 1;
                else if (i == 2 || i == 5 || i == 6 || i == 9) {
                    dp[i] = 2;
                    cnt++;
                }
            } else {
                hi = dp[i / 10];
                lo = dp[i % 10];
                if (hi == 1 && lo == 1) dp[i] = 1;
                else if (hi >= 1 && lo >= 1) {
                    dp[i] = 2;
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new RotatedDigits().rotatedDigits(10));
    }
}
