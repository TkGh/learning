package leetCode1;

/**
 * Given a string and an integer k, you need to reverse the first k characters
 * for every 2k characters counting from the start of the string. If there are
 * less than k characters left, reverse all of them. If there are less than 2k
 * but greater than or equal to k characters, then reverse the first k
 * characters and left the other as original.
 */
public class ReverseStr {
	public String reverseStr(String s, int k) {
		if (s == null) {
			return null;
		}

		char[] array = s.toCharArray();
		for (int i = 0; i < array.length; i += 2 * k) {
			reverseString(array, i, i + k - 1);
		}
		return new String(array);

	}

	private void reverseString(char[] array, int start, int end) {
		if (start > array.length - 1) {
			return;
		}
		if (end > array.length - 1) {
			end = array.length - 1;
		}

		while (start < end) {
			char tmpChar = array[start];
			array[start] = array[end];
			array[end] = tmpChar;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		String test = "helloworld";
		ReverseStr res = new ReverseStr();
		System.out.println(res.reverseStr(test, 2));
	}
}
