package leetCode1;

import java.util.*;

public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> startP = new HashMap<>();
        int[] count = new int[50000];

        Arrays.fill(count, 0);

        int minLength = Integer.MAX_VALUE;
        int maxCount = 1;
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]] += 1;
            if (!startP.containsKey(nums[i])) {
                startP.put(nums[i], i);
            } else {
                if (count[nums[i]] == maxCount) {
                    minLength = Math.min(i - startP.get(nums[i]), minLength);
                } else if (count[nums[i]] > maxCount) {
                    maxCount = count[nums[i]];
                    minLength = i - startP.get(nums[i]);
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? 1 : minLength + 1;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 2, 3, 1, 4, 2};
        System.out.println(new DegreeOfAnArray().findShortestSubArray(test));
    }
}
