package leetCode1;

public class StrStr {
	public int strStr(String haystack, String needle) {
		if (needle.length() == 0) {
			return 0;
		}
		if (haystack.length() == 0) {
			if (needle.length() == 0) {
				return 0;
			} else {
				return -1;
			}
		}

		if (haystack.length() < needle.length()) {
			return -1;
		}

		int res = -1;
		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(0) && i + needle.length() <= haystack.length()) {
				if (haystack.substring(i, i + needle.length()).equals(needle)) {
					res = i;
					break;
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		String haystack = "a";
		String needle = "";
		StrStr res = new StrStr();
		System.out.println(res.strStr(haystack, needle));
	}
}
