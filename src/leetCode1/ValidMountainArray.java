package leetCode1;

public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A.length <= 2) return false;
        if (A[0] >= A[1]) return false;
        if (A[A.length - 2] <= A[A.length - 1]) return false;

        int i = 0;
        while (i < A.length - 1 && A[i + 1] > A[i]) {
            i++;
        }

        while (i < A.length - 1 && A[i + 1] < A[i]) {
            i++;
        }

        return i == A.length - 1 ? true : false;
    }
}
