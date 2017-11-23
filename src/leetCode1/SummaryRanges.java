package leetCode1;

import java.util.*;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        if (nums.length <= 0) {
            return res;
        }

        int start = 0, end = 1;

        while (end < nums.length) {
            if (nums[end] == nums[end - 1] + 1) {
                end++;
            } else {
                if (end - 1 - start == 0) {
                    res.add(nums[start] + "");
                } else {
                    res.add(nums[start] + "->" + nums[end - 1]);
                }
                start = end;
                end++;
            }
        }

        if (end - 1 - start == 0) {
            res.add(nums[start] + "");
        } else {
            res.add(nums[start] + "->" + nums[end - 1]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 5, 6, 7, 9};
        System.out.println(new SummaryRanges().summaryRanges(test));
    }
}
