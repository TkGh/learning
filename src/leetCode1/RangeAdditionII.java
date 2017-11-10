package leetCode1;

public class RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        int minC = n;
        int minR = m;
        for (int[] op : ops) {
            minR = Math.min(op[0], minR);
            minC = Math.min(op[1], minC);
        }

        return minC * minR;
    }
}
