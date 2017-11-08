package leetCode1;

public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r * c != nums.length * nums[0].length) {
            return nums;
        }

        int[][] res = new int[r][c];
        int currR = 0, currC = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (currC == c) {
                    currC = 0;
                    currR++;
                }
                res[currR][currC++] = nums[i][j];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] test = {{1, 2}, {3, 4}};
        new ReshapeTheMatrix().matrixReshape(test, 1, 4);
    }
}
