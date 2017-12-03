package leetCode1;

public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;

        int sum = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                if (i != Math.sqrt(num)) sum += num / i;
            }
        }

        return sum == num;
    }

    public static void main(String[] args) {
        System.out.print(new PerfectNumber().checkPerfectNumber(9999991));
    }
}
