package leetCode1;

import java.util.*;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> paths = new ArrayList<List<Integer>>();

		if (candidates == null || candidates.length == 0) {
			return paths;
		}
		Arrays.sort(candidates);
		helper(candidates, 0, target, new ArrayList<Integer>(), paths);

		return paths;
	}

	private void helper(int[] candidates, int start, int target, ArrayList<Integer> path, List<List<Integer>> paths) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			paths.add(new ArrayList<Integer>(path));
		}

		for (int i = start; i < candidates.length; i++) {
			if (i > 0 && candidates[i] == candidates[i - 1]) {
				continue;
			}
			path.add(candidates[i]);
			helper(candidates, i, target - candidates[i], path, paths);
			path.remove(path.size() - 1);
		}
	}
}
