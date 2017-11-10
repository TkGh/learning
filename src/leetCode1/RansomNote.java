package leetCode1;

import java.util.Arrays;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[27];
        Arrays.fill(letters, 0);

        char[] mag = magazine.toCharArray();
        char[] ransom = ransomNote.toCharArray();

        //count chars:
        for (char c : mag) {
            letters[c - 'a'] += 1;
        }

        //Consume chars:
        for (char c : ransom) {
            letters[c - 'a']--;
            if (letters[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
