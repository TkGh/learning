package leetCode1;

public class Partition2KEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;

        if (n < 4) return false;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 4 != 0) return false;

        sum /= 4;

        return false;
    }
}
