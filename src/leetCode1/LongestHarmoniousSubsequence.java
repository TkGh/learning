package leetCode1;

import java.util.*;

public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int longest = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            int count = map.get(nums[i]);

            if (map.containsKey(nums[i] - 1)) {
                longest = Math.max(longest, count + map.get(nums[i] - 1));
            }

            if (map.containsKey(nums[i] + 1)) {
                longest = Math.max(longest, count + map.get(nums[i] + 1));
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println(new LongestHarmoniousSubsequence().findLHS(nums));
    }
}
