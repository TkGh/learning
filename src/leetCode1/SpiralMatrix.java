package leetCode1;

import java.util.*;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length < 1) {
            return new ArrayList<>();
        }
        int maxRow = matrix.length - 1;
        int minRow = 0;
        int maxCol = matrix[0].length - 1;
        int minCol = 0;

        List<Integer> res = new ArrayList<>();
        int i;
        while (true) {
            for (i = minCol; i <= maxCol; i++) {
                res.add(matrix[minRow][i]);
            }
            minRow++;
            if (minRow > maxRow) {
                break;
            }

            for (i = minRow; i <= maxRow; i++) {
                res.add(matrix[i][maxCol]);
            }
            maxCol--;
            if (minCol > maxCol) {
                break;
            }

            for (i = maxCol; i >= minCol; i--) {
                res.add(matrix[maxRow][i]);
            }
            maxRow--;
            if (minRow > maxRow) {
                break;
            }

            for (i = maxRow; i >= minRow; i--) {
                res.add(matrix[i][minCol]);
            }
            minCol++;
            if (minCol > maxCol) {
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}};
        List<Integer> res = new SpiralMatrix().spiralOrder(matrix);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
