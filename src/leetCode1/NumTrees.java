package leetCode1;

import java.math.*;

public class NumTrees {
	public int numTrees(int n) {
		if (n <= 0) {
			return 0;
		}

		BigInteger dividend = BigInteger.valueOf(1);
		BigInteger divisor = BigInteger.valueOf(1);

		for (int i = n * 2; i > n + 1; i--) {
			dividend = dividend.multiply(BigInteger.valueOf(i));
		}

		for (int i = 1; i <= n; i++) {
			divisor = divisor.multiply(BigInteger.valueOf(i));
		}

		return dividend.divide(divisor).intValue();
	}

	public static void main(String[] args) {
		NumTrees res = new NumTrees();
		System.out.println(res.numTrees(19));
	}
}
