package leetCode1;

public class FindNthDigit {
	public int findNthDigit(int n) {
		long count = 9;
		int len = 1;
		int start = 1;

		while (n > count * len) {
			n -= count * len;
			count *= 10;
			len += 1;
			start *= 10;
		}

		start += (n - 1) / len;
		String res = Integer.toString(start);
		return Character.getNumericValue(res.charAt((n - 1) % len));
	}

	public static void main(String[] args) {
		FindNthDigit a = new FindNthDigit();
		System.out.println(a.findNthDigit(1000));
	}
}
