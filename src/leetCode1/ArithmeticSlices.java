package leetCode1;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        int cnt = 0;
        int gap = A[1] - A[0];
        int[] cache = new int[A.length + 1];
        for (int i = 1; i < A.length; i++) {
            if (A[i] - A[i - 1] == gap) {
                cache[i] += cache[i - 1] + 1;
            } else {
                gap = A[i] - A[i - 1];
                cache[i] = 1;
            }

            if (cache[i] >= 2) {
                cnt += cache[i] - 1;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 6, 7};
        System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(test));
    }
}
