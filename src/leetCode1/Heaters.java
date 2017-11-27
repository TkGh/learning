package leetCode1;

import java.util.*;

public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int i = 0, j = 0, res = 0;
        while (i < houses.length) {
            while (j < heaters.length - 1
                    && Math.abs(heaters[j + 1] - houses[i]) <= Math.abs(heaters[j] - houses[i])) {
                j++;
            }
            res = Math.max(res, Math.abs(heaters[j] - houses[i]));
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] houses = {1, 2, 3, 4};
        int[] heaters = {1, 4};
        System.out.println(new Heaters().findRadius(houses, heaters));
    }
}