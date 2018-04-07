package leetCode1;

import java.util.*;

public class MinimumIndexSumofTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1.length == 1) return list1;
        if (list2.length == 1) return list2;

        List<String> str = new ArrayList<>();
        Map<String, Integer> cache = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            cache.put(list1[i], i);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (cache.containsKey(list2[i])) {
                if (cache.get(list2[i]) + i < min) {
                    min = cache.get(list2[i]) + i;
                    str.clear();
                    str.add(list2[i]);
                } else if (cache.get(list2[i]) + i == min) {
                    str.add(list2[i]);
                }
            }
        }

        String[] res = new String[str.size()];
        for (int i = 0; i < str.size(); i++) {
            res[i] = str.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        String[] s1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] s2 = {"KFC", "Shogun", "Burger King"};
        String[] res = new MinimumIndexSumofTwoLists().findRestaurant(s1, s2);
        for (String s : res) {
            System.out.print(s + "\t");
        }
    }
}
