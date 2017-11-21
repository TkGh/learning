package leetCode1;


import java.util.*;

public class MaximumWidthofBinaryTree {
    private int width = 1;

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        helper(root, 1, 1, new ArrayList<>(), new ArrayList<>());

        return width;
    }

    private void helper(TreeNode node, int high, int number, List<Integer> left, List<Integer> right) {
        if (node == null) {
            return;
        }

        if (left.size() < high) {
            left.add(number);
            right.add(number);
        } else {
            if (left.get(high - 1) > number) {
                left.set(high - 1, number);
            } else if (right.get(high - 1) < number) {
                right.set(high - 1, number);
            }

        }
        int currWidth = right.get(high - 1) - left.get(high - 1) + 1;
        if (currWidth > width) {
            width = currWidth;
        }

        helper(node.left, high + 1, number * 2, left, right);
        helper(node.right, high + 1, number * 2 + 1, left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(3);

        root.left = t1;
        t1.left = t2;
        t1.right = t3;
        System.out.println(new MaximumWidthofBinaryTree().widthOfBinaryTree(root));
    }
}
