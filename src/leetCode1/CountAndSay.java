package leetCode1;

public class CountAndSay {
	public String countAndSay(int n) {
		if (n <= 0) {
			return "";
		}

		String res = "1";
		int index = 1;

		while (index < n) {
			StringBuffer sb = new StringBuffer();
			int cnt = 1;
			for (int i = 1; i < res.length(); i++) {
				if (res.charAt(i) == res.charAt(i - 1)) {
					cnt++;
				} else {
					sb.append(cnt);
					sb.append(res.charAt(i - 1));
					cnt++;
				}
			}
			sb.append(cnt);
			sb.append(res.charAt(res.length() - 1));
			res = sb.toString();
			index++;
		}

		return res;
	}
}
