package leetCode1;

public class GetSum {
	public int getSum(int a, int b) {
		if (a == 0) {
			return b;
		}
		if (b == 0) {
			return a;
		}

		while (b != 0) {
			int nand = a ^ b;
			b = (a & b) << 1;
			a = nand;
		}
		return a;
	}
}
