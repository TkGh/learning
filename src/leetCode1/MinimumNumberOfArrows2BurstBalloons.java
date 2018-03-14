package leetCode1;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrows2BurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });

        int shoots = 1;
        int range = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= range) {
                range = points[i][1] < range ? points[i][1] : range;
                continue;
            } else {
                shoots++;
                range = points[i][1];
            }
        }

        return shoots;
    }

    public static void main(String[] args) {
        int[][] test = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        System.out.println(new MinimumNumberOfArrows2BurstBalloons().findMinArrowShots(test));
    }
}
