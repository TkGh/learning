package leetCode1;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int size = s.length();
        int[] count = new int[size];
        Arrays.fill(count, 1);

        for (int i = 1; i < size; i++) {
            int prevC = 0;
            for (int j = i - 1; j >= 0; j--) {
                int temp = count[j];
                if (s.charAt(i) == s.charAt(j)) {
                    count[j] = prevC + 2;
                }
                prevC = Math.max(temp, prevC);
            }
        }
        int max = 0;
        for (int i : count) {
            max = Math.max(max, i);
        }
        return max;
    }

    public static void main(String[] args) {
        String test = "bbabb";
        System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq(test));
    }
}
