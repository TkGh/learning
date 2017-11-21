package leetCode1;

import java.util.*;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] letters = str.split(" ");

        if (pattern.length() != letters.length) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();
        char[] p = pattern.toCharArray();
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(p[i])) {
                if (map.get(p[i]).equals(letters[i])) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (map.containsValue(letters[i])) {
                    return false;
                } else {
                    map.put(p[i], letters[i]);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        if (new WordPattern().wordPattern("abba", "dog cat cat dog")) {
            System.out.println("T");
        } else {
            System.out.println("F");
        }
    }
}
