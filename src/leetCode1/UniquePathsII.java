package leetCode1;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                obstacleGrid[i][j] = -obstacleGrid[i][j];
            }
        }

        int i = 0;
        while (i < row && obstacleGrid[i][0] == 0) {
            obstacleGrid[i][0] = 1;
            i++;
        }

        i = 0;
        while (i < col && obstacleGrid[0][i] != -1) {
            obstacleGrid[0][i] = 1;
            i++;
        }

        for (i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] != -1) {
                    int left = obstacleGrid[i][j - 1] == -1 ? 0 : obstacleGrid[i][j - 1];
                    int up = obstacleGrid[i - 1][j] == -1 ? 0 : obstacleGrid[i - 1][j];
                    obstacleGrid[i][j] = left + up;
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        return obstacleGrid[row - 1][col - 1] == -1 ? 0 : obstacleGrid[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] test = {{0, 0}, {0, 0}};
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(test));
    }
}
