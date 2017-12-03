package leetCode1;

public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        int lenA = A.length, lenB = B.length;

        if (lenA < 1 || lenB < 1) return 0;

        int[][] dp = new int[lenA + 1][lenB + 1];
        int max = 0;

        for (int i = 0; i < lenA; i++) {
            for (int j = 0; j < lenB; j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = (i > 0 && j > 0) ? dp[i - 1][j - 1] + 1 : 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] B = {1, 2, 3, 4, 1, 2, 3, 4, 5};
        System.out.print(new MaximumLengthOfRepeatedSubarray().findLength(A, B));
    }
}
