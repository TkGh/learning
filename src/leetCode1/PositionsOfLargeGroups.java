package leetCode1;

import java.util.*;

public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        if (S.length() <= 2) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();

        int start = 0;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != S.charAt(start)) {
                if (i - start >= 3) {
                    List<Integer> couple = new ArrayList<>();
                    couple.add(start);
                    couple.add(i - 1);
                    res.add(couple);
                }
                start = i;
            }
        }

        if (S.length() - start >= 3) {
            List<Integer> couple = new ArrayList<>();
            couple.add(start);
            couple.add(S.length() - 1);
            res.add(couple);
        }

        return res;
    }
}
