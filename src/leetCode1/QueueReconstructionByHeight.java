package leetCode1;

import java.util.*;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0] - o1[0] != 0) return o2[0] - o1[0];
                else return o1[1] - o2[1];
            }
        });

        int[][] res = people.clone();
        for (int i = 0; i < people.length; i++) {
            insert(res, people[i][1], people[i]);
        }

        return res;
    }

    private void insert(int[][] res, int index, int[] inserted) {
        int[] tmp;
        for (; index < res.length; index++) {
            tmp = res[index];
            res[index] = inserted;
            inserted = tmp;
        }
    }

    public static void main(String[] args) {
        int[][] a = {{7, 0}, {4, 4}, {7, 1}, {6, 1}, {5, 2}, {5, 0}};
        int[][] res = new QueueReconstructionByHeight().reconstructQueue(a);
        int i = 0;
    }
}