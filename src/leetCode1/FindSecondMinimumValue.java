package leetCode1;

public class FindSecondMinimumValue {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return -1;
        }

        int min = root.val;
        int left = findSM(root.left, min);
        int right = findSM(root.right, min);

        if (left == min && right == min) {
            return -1;
        } else {
            if (left == min) {
                return right;
            }
            if (right == min) {
                return left;
            }
            return left < right ? left : right;
        }
    }

    private int findSM(TreeNode curr, int min) {
        if (curr == null) {
            return min;
        }
        if (curr.val > min) {
            return curr.val;
        }

        int left = findSM(curr.left, min);
        int right = findSM(curr.right, min);

        if (left == min && right == min) {
            return min;
        } else {
            if (left == min) {
                return right;
            }
            if (right == min) {
                return left;
            }
            return left < right ? left : right;
        }
    }
}
