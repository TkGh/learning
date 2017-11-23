package leetCode1;

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        int i = 0;
        while (i < k) {
            sum += nums[i];
            i++;
        }

        int max = sum;

        for (; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            max = Math.max(max, sum);
        }

        return max / (double) k;
    }

    public static void main(String[] args) {
        int[] test = {1, 12, -5, -6, 50, 3};
        System.out.println(new MaximumAverageSubarrayI().findMaxAverage(test, 4));
    }
}
