package leetCode1;

import java.util.*;

public class CanConstruct {
	public boolean canConstruct(String ransomNote, String magazine) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < magazine.length(); i++) {
			if (map.containsKey(magazine.charAt(i))) {
				int temp = map.get(magazine.charAt(i));
				map.put(magazine.charAt(i), temp + 1);
			} else {
				map.put(magazine.charAt(i), 1);
			}

		}

		for (int i = 0; i < ransomNote.length(); i++) {
			if (map.containsKey(ransomNote.charAt(i))) {
				int temp = map.get(ransomNote.charAt(i));
				if (temp <= 0) {
					return false;
				}
				map.put(ransomNote.charAt(i), temp - 1);
			} else {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		String a = "fffbfg";
		String b = "effjfggbffjdgbjjhhdegh";
		CanConstruct c = new CanConstruct();
		if (c.canConstruct(a, b)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
