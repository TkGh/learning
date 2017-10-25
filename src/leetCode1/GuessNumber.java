package leetCode1;

public class GuessNumber extends GuessGame {
    public int guessNumber(int n) {
        int i = 1, j = n;

        int res = 0;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int tempRes = guess(mid);
            if (tempRes == 0) {
                res = mid;
                break;
            } else if (tempRes == 1) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        GuessNumber test = new GuessNumber();
        System.out.println(test.guessNumber(10));
    }
}

class GuessGame {
    private final int picked = 4;

    public int guess(int n) {
        return n < picked ? 1 : (n == picked ? 0 : -1);
    }

}