package leetCode1;

public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        if (A.length == 1) return true;

        int inc = 0, dec = 0;
        for (int i = 1, j = 0; i < A.length; i++, j++) {
            if (A[i] - A[j] > 0) inc = 1;
            if (A[i] - A[j] < 0) dec = 1;
        }

        if (inc == 1 && dec == 1) return false;

        return true;
    }
}
