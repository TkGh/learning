package leetCode1;

import java.util.*;

public class PrintBinaryTree {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();

        int ro = findHeight(root), col = (int) (Math.pow(2, ro) - 1);
        List<String> row = new ArrayList<>();
        for (int i = 0; i < col; i++) {
            row.add("");
        }
        for (int i = 0; i < ro; i++) {
            res.add(new ArrayList<>(row));
        }
        setNodes(root, res, 0, ro, 0, col - 1);

        return res;
    }

    private void setNodes(TreeNode h, List<List<String>> res, int row, int total, int pos1, int pos2) {
        if (row == total || h == null) return;
        res.get(row).set((pos1 + pos2) / 2, Integer.toString(h.val));
        setNodes(h.left, res, row + 1, total, pos1, (pos1 + pos2) / 2 - 1);
        setNodes(h.right, res, row + 1, total, (pos1 + pos2) / 2 + 1, pos2);

    }

    private int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode t1 = new TreeNode(4);
        root.left = left;
        root.right = right;
        right.left = t1;
        new PrintBinaryTree().printTree(root);
    }
}
