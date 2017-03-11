package leetCode1;

import java.util.*;

public class Draft {
	public static void main(String[] args) {

		HashSet<List<Integer>> test2 = new HashSet<>();

		List<Integer> res = new ArrayList<>();
		List<Integer> res2 = new ArrayList<>();
		res.add(1);
		res.add(2);
		res2.add(1);
		res2.add(23);
		test2.add(res2);
		test2.add(res);
		res.remove(res.size() - 1);
		System.out.println(test2.size());
	}

}
