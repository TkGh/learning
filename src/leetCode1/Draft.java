package leetCode1;

import java.util.*;

public class Draft {
	public static void main(String[] args) {
		List<Integer> res = new ArrayList<>();
		res.add(1);
		res.add(2);
		h(res);
		for (int e : res) {
			System.out.println(e);
		}
	}

	private static void h(List<Integer> r) {
		int temp = r.get(0);
		r.set(0, r.get(1));
		r.set(1, temp);
	}

}
