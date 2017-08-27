package leetCode1;

public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        int max1 = -1001, max2 = -1001, max3 = -1001;
        int min1 = 1001, min2 = 1001;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }

        int max = Math.max(max1 * max2 * max3, max1 * min1 * min2);
        return max;
    }

    public static void main(String[] args) {
        MaximumProductOfThreeNumbers test = new MaximumProductOfThreeNumbers();
        int[] nums = {-1, -2, -3};
        System.out.println(test.maximumProduct(nums));
    }
}
