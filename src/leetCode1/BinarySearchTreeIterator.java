package leetCode1;

import java.util.*;

public class BinarySearchTreeIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BinarySearchTreeIterator(TreeNode root) {
        push(root);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.empty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode h = stack.pop();
        push(h.right);
        return h.val;
    }

    private void push(TreeNode h) {
        while (h != null) {
            stack.push(h);
            h = h.left;
        }
    }
}

/**
 * Your BinarySearchTreeIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */