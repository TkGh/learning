package leetCode1;

import java.util.*;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || s == "") {
            return true;
        }

        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1).equals(c2)) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (map.containsValue(c2)) {
                    return false;
                } else {
                    map.put(c1, c2);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        if (new IsomorphicStrings().isIsomorphic("add", "egg")) {
            System.out.println("T");
        } else {
            System.out.println("F");
        }
    }
}
