package leetCode1;

public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;

        int res = 10;
        int available = 9;
        int base = 9;
        while (n-- > 1 && available > 0) {
            base = base * available;
            res += base;
            available--;
        }

        return res;
    }

    public static void main(String[] args){
        System.out.print(new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(3));
    }
}
