package leetCode1;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}

		if (strs.length == 1) {
			return strs[0];
		}

		for (int i = 0; i < strs[0].length(); i++) {
			String subStr = strs[0].substring(0, i + 1);
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].length() <= i || !strs[j].substring(0, i + 1).equals(subStr)) {
					return subStr.substring(0, i);
				}
			}
		}
		return strs[0];
	}

	public static void main(String[] args) {
		String[] test = { "cdww", "cd","cdq" };
		LongestCommonPrefix res = new LongestCommonPrefix();
		System.out.println(res.longestCommonPrefix(test));
	}
}
