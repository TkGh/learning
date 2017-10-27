package leetCode1;

public class TrimBST {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return root;
        }

        while (root != null) {
            if (root.val >= L && root.val <= R) {
                break;
            } else if (root.val < L) {
                root = root.right;
            } else if (root.val > R) {
                root = root.left;
            }
        }

        //Trim Left subtree:
        TreeNode currL = root.left;
        TreeNode prevL = root;
        while (currL != null) {
            if (currL.val < L) {
                prevL.left = currL.right;
                currL = currL.right;
            } else {
                prevL = currL;
                currL = currL.left;
            }
        }

        //Trim right subtree:
        TreeNode currR = root.right;
        TreeNode prevR = root;
        while (currR != null) {
            if (currR.val > R) {
                prevR.right = currR.left;
                currR = currR.left;
            } else {
                prevR = currR;
                currR = currR.right;
            }
        }

        return root;
    }
}
