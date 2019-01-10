package leetCode1;

import java.util.*;

public class UncommonWordsfromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        if (A.length() == 0 && B.length() == 0) return null;

        Map<String, Integer> cache = new HashMap();

        List<String> coll = new ArrayList<>();

        for (String str : A.split(" ")) {
            if (cache.containsKey(str)) {
                cache.put(str, cache.get(str) + 1);
            } else {
                cache.put(str, 1);
                coll.add(str);
            }
        }

        for (String str : B.split(" ")) {
            if (cache.containsKey(str)) {
                cache.put(str, cache.get(str) + 1);
            } else {
                cache.put(str, 1);
                coll.add(str);
            }
        }

        List<String> res = new ArrayList<>();
        for (String str : coll) {
            if (cache.get(str) == 1) res.add(str);
        }

        return res.toArray(new String[0]);
    }
}
