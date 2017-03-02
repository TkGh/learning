package leetCode1;

import java.util.*;

public class CombinationSum3 {
	public List<List<Integer>> combinationSum3(int k, int n) {
		int[] candidates = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		List<List<Integer>> paths = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return paths;
		}

		helper(candidates, 0, n, new ArrayList<Integer>(), paths);
		int index = 0;
		while (index < paths.size()) {
			if (paths.get(index).size() != k) {
				paths.remove(index);
			} else {
				index++;
			}
		}

		return paths;

	}

	private void helper(int[] candidates, int start, int target, ArrayList<Integer> path, List<List<Integer>> paths) {
		if (target < 0) {
			return;
		}

		if (target == 0) {
			paths.add(new ArrayList<Integer>(path));
		}

		if (start >= candidates.length) {
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			path.add(candidates[i]);
			helper(candidates, i + 1, target - candidates[i], path, paths);
			path.remove(path.size() - 1);
		}
	}
}
