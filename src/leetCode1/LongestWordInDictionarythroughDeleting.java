package leetCode1;

import java.util.*;

public class LongestWordInDictionarythroughDeleting {
    private String[] aux;

    public String findLongestWord(String s, List<String> d) {
        if (s.length() == 0 || d.size() == 0) return "";

        //Sort dictionary by word length:
        char[][] sortedDic = sort(d);

        //find the longest word:
        char[] str = s.toCharArray();
        int strLength = str.length;
        for (int i = 0; i < d.size(); i++) {
            int wordLength = sortedDic[i].length;//
            int countW = 0;                                         //index of word in dictionary.
            int countStr = 0;                                       //index of s.
            while (countW < wordLength && countStr < strLength) {
                if (str[countStr] == sortedDic[i][countW]) {
                    countStr++;
                    countW++;
                } else {
                    countStr++;
                }
            }
            if (countW == wordLength) {
                String result = new String();
                for (char c : sortedDic[i]) {
                    result += c;
                }
                return result;
            }
        }

        return "";
    }

    private char[][] sort(List<String> dic) {
        int size = dic.size();
        aux = new String[size];
        sort(dic, 0, size - 1);
        char[][] rs = new char[size][];
        for (int i = 0; i < size; i++) {
            rs[i] = dic.get(i).toCharArray();
        }

        return rs;

    }

    private void sort(List<String> dic, int low, int high) {
        if (high <= low) {
            return;
        }

        int mid = low + (high - low) / 2;
        sort(dic, low, mid);
        sort(dic, mid + 1, high);
        merge(dic, low, mid, high);
    }

    private void merge(List<String> dic, int low, int mid, int high) {
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            aux[k] = dic.get(k);
        }

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                dic.set(k, aux[j++]);
            } else if (j > high) {
                dic.set(k, aux[i++]);
            } else if (aux[i].length() > aux[j].length()) {
                dic.set(k, aux[i++]);
            } else if (aux[i].length() == aux[j].length()) {
                if (aux[i].compareTo(aux[j]) < 0) {
                    dic.set(k, aux[i++]);
                } else {
                    dic.set(k, aux[j++]);
                }
            } else {
                dic.set(k, aux[j++]);
            }
        }
    }

    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("ale");
        test.add("apple");
        test.add("monkey");
        test.add("plea");
        String v = "abpcplea";
        LongestWordInDictionarythroughDeleting a = new LongestWordInDictionarythroughDeleting();
        System.out.print(a.findLongestWord(v, test));
    }
}
