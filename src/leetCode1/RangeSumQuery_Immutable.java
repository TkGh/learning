package leetCode1;

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
public class RangeSumQuery_Immutable {
    private int[] cache;

    public RangeSumQuery_Immutable(int[] nums) {
        cache = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            cache[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        j = j >= cache.length ? cache.length - 1 : j;

        if (i == 0) {
            return cache[j];
        }
        return cache[j] - cache[i - 1];
    }
}

