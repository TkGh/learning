package leetCode1;

public class HammingDistance {
	public int hammingDistance(int x, int y) {
		int tempX = x - (x & y);
		int tempY = y - (x & y);

		int countX;
		int countY;
		for (countX = 0; tempX != 0; countX++) {
			tempX = tempX & (tempX - 1);
		}
		for (countY = 0; tempY != 0; countY++) {
			tempY = tempY & (tempY - 1);
		}

		return countX + countY;
	}

	public static void main(String[] args) {
		HammingDistance res = new HammingDistance();
		System.out.println(res.hammingDistance(3, 1));
	}
}
