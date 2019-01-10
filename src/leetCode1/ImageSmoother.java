package leetCode1;

public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        int row = M.length;
        int col = M[0].length;

        int[][] ans = new int[row][col];

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {
                int indexSum = 1;
                int valueSum = M[i][j];

                if (i - 1 >= 0) {
                    indexSum++;
                    valueSum = valueSum + M[i - 1][j];
                    if (j - 1 >= 0) {
                        indexSum++;
                        valueSum = valueSum + M[i - 1][j - 1];
                    }
                    if (j + 1 < col) {
                        indexSum++;
                        valueSum = valueSum + M[i - 1][j + 1];
                    }
                }
                if (i + 1 < row) {
                    indexSum++;
                    valueSum = valueSum + M[i + 1][j];
                    if (j - 1 >= 0) {
                        indexSum++;
                        valueSum = valueSum + M[i + 1][j - 1];
                    }
                    if (j + 1 < col) {
                        indexSum++;
                        valueSum = valueSum + M[i + 1][j + 1];
                    }
                }
                if (j - 1 >= 0) {
                    indexSum++;
                    valueSum = valueSum + M[i][j - 1];
                }
                if (j + 1 < col) {
                    indexSum++;
                    valueSum = valueSum + M[i][j + 1];
                }

                ans[i][j] = valueSum / indexSum;
            }

        }

        return ans;
    }
}
