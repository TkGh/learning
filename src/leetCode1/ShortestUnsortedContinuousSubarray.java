package leetCode1;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int start = nums.length - 1, end = -1;

        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < (start < i ? start : i); j++) {
                if (nums[j] > nums[i]) {
                    start = j;
                    end = end > i ? end : i;
                }
            }
        }

        return end - start <= 0 ? 0 : end - start + 1;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 5, 4};
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(test));
    }
}
