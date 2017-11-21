package leetCode1;

import java.util.concurrent.TimeUnit;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        return constr(nums, 0, nums.length - 1);
    }

    private TreeNode constr(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootPos = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[rootPos]) {
                rootPos = i;
            }
        }

        TreeNode root = new TreeNode(nums[rootPos]);
        root.left = constr(nums, start, rootPos - 1);
        root.right = constr(nums, rootPos + 1, end);

        return root;
    }

    public static void main(String[] args) {
        int[] test = {3, 2, 1, 6, 0, 5};
        TreeNode root = new MaximumBinaryTree().constructMaximumBinaryTree(test);
        System.out.println(" ");
    }
}
