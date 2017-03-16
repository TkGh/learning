package leetCode1;

import java.util.*;

public class DetectCapitalUse {
	public boolean detectCapitalUse(String word) {
		if (word.length() == 1) {
			return true;
		}

		char[] low = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		HashSet<Character> lo = new HashSet<>();
		Set<Character> up = new HashSet<>();
		for (int i = 0; i < low.length; i++) {
			lo.add(low[i]);
			up.add(Character.toUpperCase(low[i]));
		}

		if (up.contains(word.charAt(0))) {
			int upper = 0;
			if (up.contains(word.charAt(1))) {
				upper = 1;
			}
			for (int i = 2; i < word.length(); i++) {
				if (upper == 1 && !up.contains(word.charAt(i))) {
					return false;
				}
				if (upper == 0 && !lo.contains(word.charAt(i))) {
					return false;
				}
			}
		} else {
			for (int i = 1; i < word.length(); i++) {
				if (!lo.contains(word.charAt(i))) {
					return false;
				}
			}
		}

		return true;

	}

	public static void main(String[] args) {
		String test = "eW";
		DetectCapitalUse res = new DetectCapitalUse();
		if (res.detectCapitalUse(test)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
