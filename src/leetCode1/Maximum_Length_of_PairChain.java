package leetCode1;

import java.util.Arrays;
import java.util.Comparator;

public class Maximum_Length_of_PairChain {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length < 1) {
            return 0;
        }
        Arrays.sort(pairs, (o1, o2) -> (o1[0] - o2[0] == 0 ? o1[1] - o2[1] : o1[0] - o2[0]));

        int[][] list = new int[pairs.length][2];
        list[0] = pairs[0];
        int len = 1;

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > list[len - 1][1]) {
                list[len] = pairs[i];
                len++;
            } else if (pairs[i][1] < list[0][0]) {
                list[0] = pairs[i];
            } else {
                int tar = find(list, -1, len - 1, pairs[i]);
                if (list[tar][1] > pairs[i][1]) {
                    list[tar] = pairs[i];
                }
            }
        }

        return len;
    }

    private static int find(int[][] pairs, int l, int r, int[] val) {
        while (r - 1 > l) {
            int m = l + (r - l) / 2;
            if (pairs[m][1] < val[0]) {
                l = m;
            } else {
                r = m;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[][] test = {{8, 10}, {9, 10}, {-3, -2}, {7, 8}, {4, 5}, {0, 9}, {-3, 7}, {-3, 7}, {-4, 5}};
        System.out.print(new Maximum_Length_of_PairChain().findLongestChain(test));
    }
}
