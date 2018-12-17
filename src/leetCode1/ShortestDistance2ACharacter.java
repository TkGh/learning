package leetCode1;

public class ShortestDistance2ACharacter {
    public int[] shortestToChar(String S, char C) {
        if (S.length() == 1) return new int[]{0};

        int[] res = new int[S.length()];

        int prev = 0;

        while (S.charAt(prev) != C) prev++;

        for (int i = prev; i >= 0; i--) {
            res[i] = prev - i;
        }

        for (int i = prev + 1; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                for (int j = i; j > prev; j--) {
                    res[j] = Math.min(res[j], i - j);
                }
                prev = i;
            } else {
                res[i] = i - prev;
            }
        }

        return res;
    }
}
