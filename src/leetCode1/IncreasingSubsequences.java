package leetCode1;

import java.util.*;

public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        calculateEach(nums, set, new ArrayList<>(), 0);

        List<List<Integer>> res = new ArrayList(set);
        return res;
    }

    private void calculateEach(int[] nums, Set<List<Integer>> set, List<Integer> holder, int index) {
        if (holder.size() >= 2 && !set.contains(holder)) {
            set.add(new ArrayList<>(holder));
        }

        for (int i = index; i < nums.length; i++) {
            if (holder.size() == 0 || holder.get(holder.size() - 1) <= nums[i]) {
                holder.add(nums[i]);
                calculateEach(nums, set, holder, i + 1);
                holder.remove(holder.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {4, 6, 7, 7};
        System.out.print(new IncreasingSubsequences().findSubsequences(test));
    }
}
