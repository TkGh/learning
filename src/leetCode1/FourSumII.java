package leetCode1;

import java.util.*;

public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 0) return 0;

        Map<Integer, Integer> cache = new HashMap<>();
        int sum;
        for (int a : A) {
            for (int b : B) {
                sum = a + b;
                cache.put(sum, cache.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        for (int c : C) {
            for (int d : D) {
                if (cache.containsKey(-c - d)) {
                    res += cache.get(-c - d);
                }
            }
        }

        return res;
    }
}
