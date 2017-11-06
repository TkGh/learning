package leetCode1;

public class LongestPalindromicSubstring {
    private int resLo = 0, maxL = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }

        return s.substring(resLo, resLo + maxL);
    }

    private void helper(String s, int low, int high) {
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            low--;
            high++;
        }

        if (maxL < high - low - 1) {
            resLo = low + 1;
            maxL = high - low - 1;

        }
    }

    public static void main(String[] args) {
        String test = "abcba";
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(test));
    }
}
