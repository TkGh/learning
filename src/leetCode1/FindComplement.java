package leetCode1;

public class FindComplement {
	public int findComplement(int num) {
		int bit = 1;
		int count = 31;
		while (bit <= num && count > 0) {
			if ((num & bit) == bit) {
				num = num - bit;
			} else {
				num = num + bit;
			}
			bit = bit << 1;
			count--;
		}
		return num;
	}

	public static void main(String[] args) {
		FindComplement res = new FindComplement();
		System.out.println(res.findComplement(2147483647));
	}
}
