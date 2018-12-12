package leetCode1;

import java.util.Arrays;

public class SmallestRangeII {
    public int smallestRangeII(int[] A, int K) {
        if (A.length == 1) return 0;

        Arrays.sort(A);

        int max = 0, min;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            min = Math.min(A[0] + 2 * K, A[i + 1]);
            max = Math.max(max, A[i] + 2 * K);
            res = Math.min(res, max - min);
        }

        return res;
    }
}
