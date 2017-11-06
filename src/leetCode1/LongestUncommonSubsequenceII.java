package leetCode1;

import java.util.*;

public class LongestUncommonSubsequenceII {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        Set<String> duplicates = getDuplicates(strs);
        for (int i = 0; i < strs.length; i++) {
            if (!duplicates.contains(strs[i])) {
                if (i == 0) {
                    return strs[0].length();
                } else {
                    for (int j = 0; j < i; j++) {
                        if (isSubsequence(strs[j], strs[i])) {
                            break;
                        }
                        if (j == i - 1) {
                            return strs[i].length();
                        }
                    }

                }
            }
        }
        return -1;
    }

    private boolean isSubsequence(String str1, String str2) {
        int index1 = 0, index2 = 0;
        while (index1 < str1.length() && index2 < str2.length()) {
            if (str1.charAt(index1) == str2.charAt(index2)) {
                index2++;
            }
            index1++;
        }

        return index2 == str2.length();
    }

    private Set<String> getDuplicates(String[] strs) {
        Set<String> set = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        for (String str : strs) {
            if (set.contains(str)) {
                duplicates.add(str);
            } else {
                set.add(str);
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {
        String[] strs = {"aabbcc", "aabbcc", "cb", "abc"};
        System.out.println(new LongestUncommonSubsequenceII().findLUSlength(strs));
    }
}
