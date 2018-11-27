package leetCode1;

public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int left = 0, right = A[i].length - 1;
            while (left < right) {
                int tmp = 1 - A[i][left];
                A[i][left] = 1 - A[i][right];
                A[i][right] = tmp;
                left++;
                right--;
            }

            if (left == right) A[i][left] = 1 - A[i][left];
        }

        return A;
    }

    public static void main(String[] args) {
        int[][] test = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        FlippingAnImage a = new FlippingAnImage();
        a.flipAndInvertImage(test);
    }
}
