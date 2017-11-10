package leetCode1;

public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int min = nums[0];
        int sum = 0;
        for (int num : nums) {
            min = Math.min(min, num);
            sum += num;
        }

        return sum - nums.length * min;
    }
}
