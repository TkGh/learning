package leetCode1;

public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] res = new int[2];

        int diff = 0;
        for (int n : A) {
            diff += n;
        }
        for (int n : B) {
            diff -= n;
        }

        diff /= 2;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] - B[j] == diff) {
                    res[0] = A[i];
                    res[1] = B[j];
                    break;
                }
            }
        }

        return res;
    }
}
