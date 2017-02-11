package leetCode1;

public class CountSegments {
	public int countSegments(String s) {
		if (s.length() == 0 ) {
			return 0;
		}

		int size = s.length();
		int count = 0;
		for (int i = 1; i < size; i++) {
			if (s.charAt(i) != ' ') {
				if (s.charAt(i - 1) == ' ') {
					count++;
				}
			}
		}

		if (s.charAt(0) != ' ') {
			return count + 1;
		}
		return count;
	}

	public static void main(String[] args) {
		String a = " ";
		CountSegments b = new CountSegments();
		System.out.println(b.countSegments(a));
	}
}
