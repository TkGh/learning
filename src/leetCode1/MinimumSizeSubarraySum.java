package leetCode1;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;

        if (len == 0) {
            return 0;
        }

        int max = 0;
        for (int n : nums) {
            max += n;
        }
        if (max < s) {
            return 0;
        }

        int l = 0, r = 0;
        int sum = 0;
        int minLen = len;
        while (l < len && r < len) {
            while (r < len && sum < s) {
                sum += nums[r++];
            }
            while (l < r && sum >= s) {
                sum -= nums[l++];
            }
            minLen = Math.min(r - l + 1, minLen);
        }

        return minLen;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 2, 4, 3};
        MinimumSizeSubarraySum b = new MinimumSizeSubarraySum();
        System.out.println(b.minSubArrayLen(7, a));
    }
}

/**
 * Old answer
 */
//class Solution{
//    public int minSubArrayLen(int s, int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//
//        if (nums.length == 1) {
//            if (nums[0] >= s) {
//                return 1;
//            } else {
//                return 0;
//            }
//        }
//
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//        }
//        if (sum < s) {
//            return 0;
//        }
//
//        int size = nums.length;
//        int minLens = Integer.MAX_VALUE;
//        sum = 0;
//        for (int i = 0; i < size; i++) {
//            for (int j = i; j < size; j++) {
//                sum += nums[j];
//                if (sum >= s) {
//                    minLens = Math.min(minLens, j - i + 1);
//                    break;
//                }
//            }
//            sum = 0;
//        }
//
//        return minLens;
//    }
//}