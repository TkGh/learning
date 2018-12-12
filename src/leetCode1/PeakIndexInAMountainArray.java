package leetCode1;

public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        return helper(0, A.length - 1, A);
    }

    private int helper(int low, int high, int[] A) {
        if (low == high) return low;

        int mid = (high - low) / 2 + low;
        if (A[mid] < A[mid + 1]) {
            return helper(mid + 1, high, A);
        } else {
            return helper(low, mid, A);
        }
    }
}
