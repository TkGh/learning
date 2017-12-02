package leetCode1;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid.length < 1 && grid[0].length < 1) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i > 0 && j > 0) {
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
                } else if (i > 0) {
                    grid[i][j] = grid[i][0] + grid[i - 1][0];
                } else if (j > 0) {
                    grid[0][j] = grid[0][j] + grid[0][j - 1];
                }
            }
        }

        return grid[row - 1][col - 1];
    }
}
