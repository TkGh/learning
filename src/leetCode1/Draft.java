package leetCode1;

import java.util.*;

public class Draft {
	public static void main(String[] args) {
		List<String> test = new ArrayList<String>();
		test.add("1");
		test.add("2");

		List<String> res = test;

		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
}
