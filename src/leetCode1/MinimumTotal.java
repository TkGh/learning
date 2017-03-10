package leetCode1;

import java.util.*;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below. Bonus point if you are able to
 * do this using only O(n) extra space, where n is the total number of rows in
 * the triangle.
 */
public class MinimumTotal {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}

		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j < i + 1; j++) {
				triangle.get(i).set(j, helper(triangle, i, j));
			}
		}
		return triangle.get(0).get(0);

	}

	private int helper(List<List<Integer>> triangle, int row, int column) {
		if (triangle.get(row + 1).get(column) > triangle.get(row + 1).get(column + 1)) {
			return triangle.get(row).get(column) + triangle.get(row + 1).get(column + 1);
		} else {
			return triangle.get(row).get(column) + triangle.get(row + 1).get(column);
		}
	}
}
