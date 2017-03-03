package leetCode1;

public class ReverseVowels {
	public String reverseVowels(String s) {
		if (s.length() == 0 || s.length() == 1) {
			return s;
		}

		class isVowels {
			public boolean isVowel(char c) {
				return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I'
						|| c == 'O' || c == 'U';
			}
		}

		isVowels judge = new isVowels();
		char[] arr = s.toCharArray();
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			if (judge.isVowel(arr[left]) && judge.isVowel(arr[right])) {
				char temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			} else if (judge.isVowel(s.charAt(left))) {
				right--;
			} else {
				left++;
			}
		}

		return new String(arr);
	}

	public static void main(String[] args) {
		String a = "Aa";
		ReverseVowels b = new ReverseVowels();
		System.out.print(b.reverseVowels(a));
	}
}
