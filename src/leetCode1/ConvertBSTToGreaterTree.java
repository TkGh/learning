package leetCode1;

public class ConvertBSTToGreaterTree {
    TreeNode prev = null;

    public TreeNode convertBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        helper(root);

        return root;
    }

    private void helper(TreeNode h) {
        if (h == null) {
            return;
        }
        helper(h.right);
        if (prev != null) {
            h.val += prev.val;
        }
        prev = h;
        helper(h.left);
    }
}
