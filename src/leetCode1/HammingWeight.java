package leetCode1;

public class HammingWeight {
	public int hammingWeight(int n) {
		int count;

		for (count = 0; n != 0; count++) {
			n &= n - 1;
		}
		return count;
	}

	public static void main(String[] args) {
		HammingWeight res = new HammingWeight();
		System.out.println(res.hammingWeight(127));
	}
}
