package leetCode1;

import java.util.*;

public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();

        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            double sum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode dump = list.remove(0);
                sum += (double) dump.val;
                if (dump.left != null) {
                    list.add(dump.left);
                }
                if (dump.right != null) {
                    list.add(dump.right);
                }
            }
            res.add(sum / size);
        }

        return res;
    }
}
