package leetCode1;

public class GetMinimumDifference {
    public int getMinimumDifference(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }

        int[] min = {Integer.MAX_VALUE};


        helper(root, min);
        return min[0];
    }

    private void helper(TreeNode root, int[] min) {
        int ceiling = findLeft(root);
        int floor = findRight(root);

        int leftV = ceiling > 0 ? root.val - ceiling : Integer.MAX_VALUE;
        int rightV = floor > 0 ? floor - root.val : Integer.MAX_VALUE;

        if (leftV < rightV) {
            min[0] = leftV < min[0] ? leftV : min[0];
        } else {
            min[0] = rightV < min[0] ? rightV : min[0];
        }

        if (root.left != null) {
            helper(root.left, min);
        }
        if (root.right != null) {
            helper(root.right, min);
        }
    }

    private int findLeft(TreeNode curr) {
        if (curr.left == null) {
            return -1;
        } else {
            curr = curr.left;
        }

        while (curr.right != null) {
            curr = curr.right;
        }

        return curr.val;
    }

    private int findRight(TreeNode curr) {
        if (curr.right == null) {
            return -1;
        } else {
            curr = curr.right;
        }

        while (curr.left != null) {
            curr = curr.left;
        }
        return curr.val;
    }

    public static void main(String[] args) {
        GetMinimumDifference test = new GetMinimumDifference();

        TreeNode root = new TreeNode(543);
        TreeNode t1 = new TreeNode(384);
        TreeNode t2 = new TreeNode(445);
        TreeNode t3 = new TreeNode(652);
        TreeNode t4 = new TreeNode(699);


        root.left = t1;
        t1.right = t2;
        root.right = t3;
        t3.right = t4;

        System.out.println(test.getMinimumDifference(root));
        System.out.println(new BetterSolution().getMinimumDifference(root));
    }
}


class BetterSolution {
    TreeNode prev = null;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev != null) {
            min = Math.min(min, root.val - prev.val);
        }
        prev = root;
        inorder(root.right);

    }
}