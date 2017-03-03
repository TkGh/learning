package leetCode1;

import java.util.*;

public class CombinationSum2 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> paths = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return paths;
		}

		Arrays.sort(candidates);
		helper(candidates, 0, target, new ArrayList<Integer>(), paths);

		for (int i = 0; i < paths.size(); i++) {
			int j = i + 1;
			while (j < paths.size()) {
				if (paths.get(i).equals(paths.get(j))) {
					paths.remove(j);
				} else {
					j++;
				}
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

	public static void main(String[] args) {
		// int[] candidates = { 2, 2, 2 };
		// CombinationSum2 res = new CombinationSum2();
		//
		// List<List<Integer>> r = res.combinationSum2(candidates, 4);
	}
}
