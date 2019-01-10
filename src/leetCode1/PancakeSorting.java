package leetCode1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PancakeSorting {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        if (A.length == 1) return res;

        LinkedList<Integer> list = new LinkedList<>();
        for (int num : A) {
            list.add(num);
        }

        for (int len = A.length; len > 0; len--) {
            LinkedList<Integer> newList = new LinkedList<>();
            int i = 0;
            while (list.get(i) != len) {
                newList.add(list.get(i));
                i++;
            }

            if (i == len - 1) {
                list.removeLast();
                continue;
            }

            if (i != 0) res.add(i + 1);
            res.add(len);
            for (int j = i + 1; j < len; j++) {
                newList.addFirst(list.get(j));
            }

            list = newList;
        }

        return res;
    }
}
