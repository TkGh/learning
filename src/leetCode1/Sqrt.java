package leetCode1;

public class Sqrt {
	public static int mySqrt(int x) {
		if (x <= 0) {
			return 0;
		}

		double res = 0;
		res = Math.pow((double) x, 1.0 / 2);
		return (int) res;
	}
	public static void main(String[] args) {
		System.out.println(mySqrt(9));
	}
}
