package leetCode1;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length < 1 || grid[0].length < 1) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    max = Math.max(max, helper(grid, i, j));
                }
            }
        }

        return max;
    }

    private int helper(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1 + helper(grid, i - 1, j) + helper(grid, i + 1, j) + helper(grid, i, j - 1) + helper(grid, i, j + 1);
        }

        return 0;
    }

    public static void main(String[] args) {
        int[][] test = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(test));
    }
}
