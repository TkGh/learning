package leetCode1;

/**
 * Write a function that takes a string as input and returns the string
 * reversed.
 */
public class ReverseString {
	public String reverseString(String s) {
		if (s == null) {
			return null;
		}

		char[] array = s.toCharArray();
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			char tmpChar = array[left];
			array[left] = array[right];
			array[right] = tmpChar;
			left++;
			right--;
		}
		return new String(array);
	}

	public static void main(String[] args) {
		String test = "hello";
		ReverseString res = new ReverseString();
		System.out.println(res.reverseString(test));
	}
}
