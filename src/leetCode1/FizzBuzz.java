package leetCode1;

import java.util.*;

public class FizzBuzz {
	public static void sort(int n) {
		ArrayList<String> sortOf = new ArrayList<String>();

		for (Integer i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				sortOf.add("   Fizz Buzz   ");
			} else if (i % 5 == 0) {
				sortOf.add("   Buzz   ");
			} else if (i % 3 == 0) {
				sortOf.add("   Fizz   ");
			} else {
				sortOf.add(i.toString());
			}
		}

		for (String e : sortOf) {
			System.out.print(e);
		}
	}
}
