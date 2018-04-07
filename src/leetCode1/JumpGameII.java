package leetCode1;

import java.util.Arrays;

public class JumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        if (nums.length == 2) return 1;

        int cnt = 0;
        int range = 0;
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == range) {
                cnt++;
                range = max;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] test = {7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
        System.out.print(new JumpGameII().jump(test));
    }
}
