package leetCode1;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums.length <= 1) {
            return -1;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }


        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                currSum += nums[i - 1];
            }
            if (sum - nums[i] - currSum == currSum) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] test = {-1, -1, -1, 0, 1, 1};
        System.out.println(new FindPivotIndex().pivotIndex(test));
    }
}
