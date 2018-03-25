package leetCode1;

import java.util.*;

public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        if (N < 10) return N;
        List<Integer> digits = new ArrayList<>();
        int fake = N;
        while (fake > 0) {
            digits.add(0, fake % 10);
            fake /= 10;
        }

        int i = 1;
        for (; i < digits.size(); i++) {
            if (digits.get(i) < digits.get(i - 1)) break;
        }

        if (i == digits.size()) return N;

        for (int j = i + 1; j < digits.size(); j++) {
            digits.set(j, 9);
        }

        for (; i > 0; i--) {
            if (digits.get(i - 1) > digits.get(i) - 1) {
                digits.set(i, 9);
            } else {
                digits.set(i, digits.get(i) - 1);
                break;
            }
        }

        if (i == 0) digits.set(0, digits.get(0) - 1);

        int res = 0;
        for (int j = 0; j < digits.size(); j++) {
            res = res * 10 + digits.get(j);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MonotoneIncreasingDigits().monotoneIncreasingDigits(1234));
    }
}
