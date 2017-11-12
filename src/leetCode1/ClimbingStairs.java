package leetCode1;

public class ClimbingStairs {

    public int climbStairs(int n) {
        int a = 1, b = 2;
        while (n > 2) {
            a += b;
            b += a;
            n -= 2;
        }

        return n == 2 ? b : a;
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(5));
    }
}
