package leetCode1;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        if (A.length == 1) return A;

        int odd = 0, even = A.length - 1;

        for (; odd < A.length; odd++) {
            if (A[odd] % 2 == 0) continue;

            while (even > odd) {
                if (A[even] % 2 == 0) break;

                even--;
            }
            if (even <= odd) break;

            int tmp = A[even];
            A[even] = A[odd];
            A[odd] = tmp;
        }

        return A;
    }
}
