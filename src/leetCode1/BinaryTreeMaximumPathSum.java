package leetCode1;

public class BinaryTreeMaximumPathSum {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int tmp = helper(root);
        return max > tmp ? max : tmp;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = helper(node.left);
        int right = helper(node.right);

        //Compare: node+left+right : node+left : node+right : node : max
        max = Math.max(max, Math.max(node.val, Math.max(left + right + node.val, Math.max(left, right) + node.val)));

        return Math.max(node.val, Math.max(left, right) + node.val);
    }
}
