package leetCode1;

public class AddOneRow2Tree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }

        helper(root, 1, v, d);

        return root;
    }

    private void helper(TreeNode node, int high, int v, int d) {
        if (node == null || high >= d) {
            return;
        }

        if (high < d - 1) {
            helper(node.left, high + 1, v, d);
            helper(node.right, high + 1, v, d);
        } else {
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = new TreeNode(v);
            node.right = new TreeNode(v);
            node.left.left = left;
            node.right.right = right;
        }
    }
}
