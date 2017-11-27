package leetCode1;

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        if (n < 1) {
            return 0;
        }

        int start = 0;
        int end = n;
        int mid;
        while (start <= end) {
            mid = (start + end) >>> 1;
            if ((0.5 * mid * mid + 0.5 * mid) <= n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start - 1;
    }

    public static void main(String[] args) {
        System.out.println(new ArrangingCoins().arrangeCoins(3));
    }
}
