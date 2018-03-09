package leetCode1;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        helper(image, sr, sc, newColor, image[sr][sc]);

        return image;
    }

    private void helper(int[][] image, int i, int j, int newC, int oldC) {
        image[i][j] = newC;
        if (i > 0 && image[i - 1][j] == oldC) helper(image, i - 1, j, newC, oldC);
        if (i < image.length - 1 && image[i + 1][j] == oldC) helper(image, i + 1, j, newC, oldC);
        if (j > 0 && image[i][j - 1] == oldC) helper(image, i, j - 1, newC, oldC);
        if (j < image[0].length - 1 && image[i][j + 1] == oldC) helper(image, i, j + 1, newC, oldC);
    }

    public static void main(String[] args) {
        int[][] g = {{0, 0, 0}, {0, 1, 1}};
        new FloodFill().floodFill(g, 1, 1, 1);
    }
}
