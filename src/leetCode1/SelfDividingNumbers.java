package leetCode1;

import java.util.*;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int j = i;
            for (; j > 0; j /= 10) {
                if (j % 10 == 0 || i % (j % 10) != 0) break;
            }
            if (j == 0) res.add(i);
        }

        return res;
    }
}
