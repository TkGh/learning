package leetCode1;

public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int last = n & 1;
        n >>= 1;
        while (n > 0) {
            int curr = n & 1;
            if (last == curr) {
                return false;
            }
            last = curr;
            n >>= 1;
        }

        return true;
    }

    public static void main(String[] args) {
        if (new BinaryNumberWithAlternatingBits().hasAlternatingBits(2)) {
            System.out.println("T");
        } else {
            System.out.println("F");
        }
    }
}
