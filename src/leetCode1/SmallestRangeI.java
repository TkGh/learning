package leetCode1;

public class SmallestRangeI {
    public int smallestRangeI(int[] A, int K) {
        if (A.length == 1) return 0;

        int max = 0, min = 10000;
        for (int i : A) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        return max - min - 2 * K > 0 ? max - min - 2 * K : 0;
    }
}
