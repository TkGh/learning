package leetCode1;

public class BinaryTreeTilt {
    private int whole = 0;

    public int findTilt(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return 0;
        }

        helper(root);

        return whole;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);
        whole += Math.abs(right - left);

        return right + left + root.val;
    }
}
