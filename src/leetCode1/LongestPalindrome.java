package leetCode1;

import java.util.*;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int length = 0;
        HashMap<Character, Integer> count = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (count.containsKey(chars[i])) {
                count.put(chars[i], count.get(chars[i]) + 1);
            } else {
                count.put(chars[i], 1);
            }
            if (count.get(chars[i]) % 2 == 0) {
                length += 2;
            }
        }

        return length == s.length() ? length : length + 1;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("abccccdd"));
    }
}

