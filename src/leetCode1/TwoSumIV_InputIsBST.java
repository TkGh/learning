package leetCode1;

public class TwoSumIV_InputIsBST {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null || (root.left == null && root.right == null)) {
            return false;
        }

        return helper(root, root.right, k) || helper(root.left, root, k);
    }

    private boolean helper(TreeNode l, TreeNode r, int k) {
        if (l == null || r == null) {
            return false;
        }

        if (l.val + r.val == k && l != r) {
            return true;
        } else if (l.val + r.val == k) {
            return helper(l.left, r, k) || helper(l, r.right, k);
        } else if (l.val + r.val < k) {
            return helper(l.right, r, k) || helper(l, r.right, k);
        } else {
            return helper(l.left, r, k) || helper(l, r.left, k);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode l1 = new TreeNode(2);
        TreeNode l2 = new TreeNode(3);
        TreeNode l3 = new TreeNode(4);
        TreeNode l4 = new TreeNode(6);
        TreeNode l5 = new TreeNode(7);

        root.left = l2;
        l2.left = l1;
        l2.right = l3;
        root.right = l4;
        l4.right = l5;

        if (new TwoSumIV_InputIsBST().findTarget(root, 10)) {
            System.out.println("T");
        } else {
            System.out.println("F");
        }
    }
}
