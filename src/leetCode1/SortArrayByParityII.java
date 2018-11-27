package leetCode1;

public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int even = 0;
        int odd = 1;

        while (true) {
            while (even < A.length && A[even] % 2 == 0) even += 2;
            while (odd < A.length && A[odd] % 2 == 1) odd += 2;
            if (odd >= A.length || even >= A.length) break;

            int tmp = A[even];
            A[even] = A[odd];
            A[odd] = tmp;
        }

        return A;
    }
}
