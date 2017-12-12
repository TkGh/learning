package leetCode1;

public class fibonaccI {
    public int fibonacci(int n) {
        if (n == 0) return 0;

        int a = 0, b = 1;
        int res = 0;

        for (int i = 2; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }

        return res;
    }
}
