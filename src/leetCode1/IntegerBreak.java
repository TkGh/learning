package leetCode1;

public class IntegerBreak {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }

        int threes = n / 3;
        int twos = 0;
        switch (n % 3) {
            case 1:
                twos = 2;
                threes--;
                break;
            case 2:
                twos = 1;
                break;
        }

        int res = 1;
        while (threes != 0) {
            res *= 3;
            threes--;
        }
        while (twos != 0) {
            res *= 2;
            twos--;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.print(new IntegerBreak().integerBreak(8));
    }
}
