package leetCode1;

public class DiameterOfBinaryTree {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        helper(root);

        return max - 1;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        max = Math.max(max, left + 1 + right);

        return Math.max(left, right) + 1;
    }
}
