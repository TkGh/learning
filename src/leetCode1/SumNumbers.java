package leetCode1;

import java.util.*;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * @author machen
 *
 */
public class SumNumbers {
	public int sumNumbers(TreeNode root) {
		int res = 0;
		if (root == null) {
			return res;
		}
		List<Integer> sums = new ArrayList<>();

		helper(root, sums, new ArrayList<>());

		for (int i = 0; i < sums.size(); i++) {
			res += sums.get(i);
		}
		return res;
	}

	private void helper(TreeNode root, List<Integer> sums, List<Integer> sum) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			int pathSum = 0;
			for (int i = 0; i < sum.size(); i++) {
				pathSum = pathSum * 10 + sum.get(i);
			}
			pathSum = root.val + pathSum * 10;
			sums.add(pathSum);
			return;
		}

		sum.add(root.val);
		helper(root.left, sums, sum);
		helper(root.right, sums, sum);
		sum.remove(sum.size() - 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(0);
		root.left = a;
		SumNumbers res = new SumNumbers();
		System.out.println(res.sumNumbers(root));

	}
}
