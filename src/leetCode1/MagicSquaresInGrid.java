package leetCode1;

public class MagicSquaresInGrid {
    public int numMagicSquaresInside(int[][] grid) {
        if (grid.length <= 2 || grid[0].length <= 2) return 0;

        int cnt = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid.length - 1; j++) {
                if (grid[i][j] != 5) continue;

                if (grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1] == 15
                        && grid[i - 1][j - 1] + grid[i][j - 1] + grid[i + 1][j - 1] == 15
                        && grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1] == 15) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
