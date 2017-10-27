package leetCode1;

public class LongestUnivaluePath {
    private int longest = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        helper(root);

        return longest;
    }

    private int helper(TreeNode root) {


        int left = root.left != null ? helper(root.left) : 0;
        int right = root.right != null ? helper(root.right) : 0;

        int leftRes = root.left != null && root.val == root.left.val ? left + 1 : 0;
        int rightRes = root.right != null && root.val == root.right.val ? right + 1 : 0;

        longest = longest > (leftRes + rightRes) ? longest : (leftRes + rightRes);
        return Math.max(leftRes, rightRes);
    }

}
