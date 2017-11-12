package leetCode1;

import java.util.*;

public class SubtreeOfAnotherTree {
    private List<TreeNode> nodes = new ArrayList<>();

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }


        findNode(s, t.val);
        if (nodes.size() == 0) {
            return false;
        }
        for (TreeNode node : nodes) {
            if (theSame(node, t)) {
                return true;
            }
        }

        return false;
    }

    private void findNode(TreeNode h, int val) {
        if (h == null) {
            return;
        }

        if (h.val == val) {
            nodes.add(h);
        }

        findNode(h.left, val);
        findNode(h.right, val);
    }

    private boolean theSame(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        } else if (t1.val != t2.val) {
            return false;
        } else {
            return theSame(t1.left, t2.left) && theSame(t1.right, t2.right);
        }
    }

    public static void main(String[] args) {

    }
}
