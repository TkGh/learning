package leetCode1;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[0][0];
        }

        int[][] res = new int[n][n];

        int minRow = 0, maxRow = n - 1;
        int minCol = 0, maxCol = n - 1;

        int i;
        int cnt = 1;
        while (true) {
            for (i = minCol; i <= maxCol; i++) {
                res[minRow][i] = cnt++;
            }
            if (++minRow > maxRow) {
                break;
            }

            for (i = minRow; i <= maxRow; i++) {
                res[i][maxCol] = cnt++;
            }
            maxCol--;

            for (i = maxCol; i >= minCol; i--) {
                res[maxRow][i] = cnt++;
            }
            if (minRow > --maxRow) {
                break;
            }

            for (i = maxRow; i >= minRow; i--) {
                res[i][minCol] = cnt++;
            }
        }

        return res;
    }
}
