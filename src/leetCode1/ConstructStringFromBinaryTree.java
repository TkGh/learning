package leetCode1;

import java.util.*;

public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        StringBuffer sb = new StringBuffer();
        sb.append(t.val);

        String leftS = tree2str(t.left);
        String rightS = tree2str(t.right);

        if (!(leftS.equals("") && rightS.equals(""))) {
            if (leftS == "") {
                sb.append("()" + "(" + rightS + ")");
            } else if (rightS.equals("")) {
                sb.append("(" + leftS + ")");
            } else {
                sb.append("(" + leftS + ")" + "(" + rightS + ")");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);

        root.left = t1;
        t1.right = t2;
        root.right = t3;

        System.out.println(new ConstructStringFromBinaryTree().tree2str(root));
    }
}
