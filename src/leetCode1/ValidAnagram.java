package leetCode1;

import java.util.*;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {


        //Step 1: map characters from s:
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.codePointAt(i))) {
                int count = map.get(s.codePointAt(i));
                map.put(s.codePointAt(i), count + 1);
            } else {
                map.put(s.codePointAt(i), 1);
            }
        }


        //Step 2: check whether t has the same characters:
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.codePointAt(i))) {
                return false;
            } else if (map.get(t.codePointAt(i)) <= 0) {
                return false;
            } else {
                int count = map.get(t.codePointAt(i));
                map.put(t.codePointAt(i), count - 1);
            }
        }


        Iterator iter = map.entrySet().iterator();

        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            if ((int) entry.getValue() != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String a = "anagram";
        String b = "nangram";
        ValidAnagram test = new ValidAnagram();
        if (test.isAnagram(a, b)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
