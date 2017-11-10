package leetCode1;

import java.util.*;

public class TwoSum2_InputarrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];

        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int low = numbers[l];
            int high = numbers[r];
            if (low + high == target) {
                res[0] = l + 1;
                res[1] = r + 1;
                break;
            } else if (low + high < target) {
                l++;
            } else {
                r--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] test = {2, 3, 4};
        int[] res = new TwoSum2_InputarrayIsSorted().twoSum(test, 61);

    }
}
