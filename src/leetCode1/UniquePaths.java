package leetCode1;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            grid[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            grid[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }


        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(100, 17));
    }
}


//Too slow

//class Solution {
//    private int paths = 0;
//
//    public int uniquePaths(int m, int n) {
//        if (m == 1 || n == 1) {
//            return 1;
//        }
//
//        helper(1, 1, m, n);
//
//        return paths;
//    }
//
//    private void helper(int horz, int vert, int m, int n) {
//        if (horz == m || vert == n) {
//            paths++;
//            return;
//        }
//
//        helper(horz + 1, vert, m, n);
//        helper(horz, vert + 1, m, n);
//    }
//}