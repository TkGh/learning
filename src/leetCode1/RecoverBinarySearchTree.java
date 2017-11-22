package leetCode1;

public class RecoverBinarySearchTree {
    private TreeNode first;
    private TreeNode second;
    private TreeNode prev;

    public void recoverTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        helper(root);

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        helper(node.left);
        if (prev != null) {
            if (node.val < prev.val) {
                if (first == null) {
                    first = prev;
                }
                second = node;
            }
        }
        prev = node;
        helper(node.right);
    }
}
