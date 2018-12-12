package leetCode1;

import java.util.ArrayList;
import java.util.List;

public class DIStringMatch {
    public int[] diStringMatch(String S) {
        int N = S.length();

        int[] res = new int[N + 1];
        int max = N, min = 0;

        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'I') {
                res[i] = min++;
            } else {
                res[i] = max--;
            }
        }

        res[N] = max;

        return res;
    }
}
