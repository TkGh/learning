package leetCode1;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0) return 0;
        if (words.length == 1) return 1;

        String[] alphabet = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};


        StringBuffer sb = new StringBuffer();
        Set<String> cache = new HashSet<>();
        for (String str : words) {
            for (char c : str.toCharArray()) {
                sb.append(alphabet[c - 97]);
            }
            cache.add(sb.toString());
            sb.setLength(0);
        }


        return cache.size();
    }
}
