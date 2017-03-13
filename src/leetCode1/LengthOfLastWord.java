package leetCode1;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		if (s == null || s.equals("")) {
			return 0;
		}

		int blank = s.length() - 1;
		while (blank >= 0 && s.charAt(blank) == ' ') {
			blank--;
		}
		if (blank == -1) {
			return 0;
		}

		int res = 0;
		for (int i = blank; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				break;
			}
			res++;
		}

		return res;
	}

	public static void main(String[] args) {
		String test = " ";
		LengthOfLastWord res = new LengthOfLastWord();
		System.out.println(res.lengthOfLastWord(test));
	}
}
