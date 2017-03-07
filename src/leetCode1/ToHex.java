package leetCode1;

public class ToHex {
	public String toHex(int num) {
		if (num >= 0 && num < 10) {
			return Integer.toString(num);
		}

		char[] letter = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < 8 && num != 0; i++) {
			res.insert(0, letter[num & 15]);
			num = num >>> 4;
		}
		return res.toString();
	}

	public static void main(String[] args) {
		ToHex test = new ToHex();
		System.out.println(test.toHex(26));
	}
}
