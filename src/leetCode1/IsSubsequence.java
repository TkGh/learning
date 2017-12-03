package leetCode1;

import java.util.*;

/**
 * For the follow-up question:
 * there are more than 1B Ss need to be check
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        //pre-process
        HashMap<Character, List<Integer>> cache = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char tmp = t.charAt(i);
            if (!cache.containsKey(tmp)) {
                cache.put(tmp, new ArrayList<>());
            }
            cache.get(tmp).add(i);
        }

        int prev = -1;
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (!cache.containsKey(tmp)) return false;

            List list = cache.get(tmp);
            int curr = find(list, prev);
            if (curr == -1) return false;
            prev = curr;
        }

        return true;
    }

    /**
     * find the next character`s position.
     *
     * @param list the character`s cache.
     * @param prev the previous character`s position.
     * @return target character`s position, if not exists return -1.
     */
    private int find(List<Integer> list, int prev) {
        int i = 0;
        for (; i < list.size(); i++) {
            if (list.get(i) > prev) break;
        }

        return i == list.size() ? -1 : list.get(i);
    }

    public static void main(String[] args) {
        String s = "acb";
        String t = "ahbgdc";
        if (new IsSubsequence().isSubsequence(s, t)) {
            System.out.print("T");
        } else {
            System.out.print("F");
        }

    }
}

/**
 * for the original question
 */
//class Solution{
//    public boolean isSubsequence(String s, String t) {
//        char[] s1 = s.toCharArray();
//        char[] t1 = t.toCharArray();
//
//        int i = 0, j = 0;
//        while (i < s1.length && j < t1.length) {
//            if (s1[i] == t1[j]) {
//                i++;
//            }
//            j++;
//        }
//
//        return i == s1.length;
//    }
//}