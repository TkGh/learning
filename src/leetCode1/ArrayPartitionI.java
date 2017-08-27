package leetCode1;

import java.util.Arrays;

public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        ArrayPartitionI test = new ArrayPartitionI();
        int[] nums = {1, 2, 5, 3, 4, 6};
        System.out.println(test.arrayPairSum(nums));
    }
}
