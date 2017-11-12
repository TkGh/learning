package leetCode1;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        char[] chars = s.toCharArray();
        int[] count = new int[26];

        for (char c : chars) {
            count[c - 'a']++;
        }

        int i = 0;
        for (; i < chars.length; i++) {
            if (count[chars[i] - 'a'] == 1) {
                break;
            }
        }

        return i == chars.length ? -1 : i;
    }
}
