package leetCode1;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 2) return new int[]{nums[1], nums[0]};

        int len = nums.length;

        int[] res = new int[len];
        Arrays.fill(res, 1);

        int mul = nums[0];
        for (int i = 1; i < len; i++) {
            res[i] = res[i] * mul;
            mul = nums[i] * mul;
        }

        mul = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            res[i] = res[i] * mul;
            mul = nums[i] * mul;
        }

        return res;
    }
}
