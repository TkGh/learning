package leetCode1;

public class NumberOfLines2WriteString {
    public int[] numberOfLines(int[] widths, String S) {
        int[] res = new int[2];
        res[0] = 1;

        for (char c : S.toCharArray()) {
            if (widths[c - 'a'] + res[1] > 100) {
                res[1] = widths[c - 'a'];
                res[0]++;
            } else {
                res[1] += widths[c - 'a'];
            }
        }

        return res;
    }
}
