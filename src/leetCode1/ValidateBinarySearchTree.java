package leetCode1;

import java.util.*;

public class ValidateBinarySearchTree {
    private TreeNode prev;
    private boolean valid = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        helper(root);

        return valid;
    }

    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        helper(node.left);
        if (prev != null && node.val <= prev.val) {
            valid = false;
        }
        prev = node;
        helper(node.right);
    }
}
