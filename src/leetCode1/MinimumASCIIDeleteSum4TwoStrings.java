package leetCode1;

public class MinimumASCIIDeleteSum4TwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] grid = new int[s1.length() + 1][s2.length() + 1];

        int max = Integer.MAX_VALUE;

        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                if (i != s1.length() || j != s2.length()) {
                    grid[i][j] = i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j) ?
                            grid[i + 1][j + 1] : Math.min(i < s1.length() ? grid[i + 1][j] + s1.charAt(i) : max,
                            j < s2.length() ? grid[i][j + 1] + s2.charAt(j) : max);
                }
            }
        }

        return grid[0][0];
    }
}
