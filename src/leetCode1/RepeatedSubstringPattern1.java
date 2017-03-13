package leetCode1;

public class RepeatedSubstringPattern1 {
	public boolean repeatedSubstringPattern(String s) {
		for (int i = 1; i <= s.length() / 2; i++) {
			if (s.length() % i != 0) {
				continue;
			}
			StringBuilder str = new StringBuilder();
			str.append(s.substring(i));
			str.append(s.substring(0, i));
			if (str.toString().equals(s)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String test = "ab";
		RepeatedSubstringPattern1 res = new RepeatedSubstringPattern1();
		if (res.repeatedSubstringPattern(test)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
