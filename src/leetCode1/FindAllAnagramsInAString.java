package leetCode1;

import java.util.*;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        int[] count = new int[26];
        Arrays.fill(count, 0);
        char[] chars = p.toCharArray();
        for (char c : chars) {
            count[c - 'a']++;
        }

        List<Integer> res = new ArrayList<>();
        char[] chars1 = s.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            if (count[chars1[i] - 'a'] > 0 && i + p.length() <= s.length()
                    && isAnagram(s.substring(i, i + p.length()), count.clone())) {
                res.add(i);
            }
        }

        return res;
    }

    private boolean isAnagram(String s, int[] count) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            count[chars[i] - 'a']--;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(new FindAllAnagramsInAString().findAnagrams("abab","ab"));
    }
}
