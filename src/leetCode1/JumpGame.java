package leetCode1;

public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null) return false;
        if (nums.length == 1) return true;

        int reachable = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }

        return true;
    }
}
