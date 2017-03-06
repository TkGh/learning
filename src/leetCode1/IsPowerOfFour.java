package leetCode1;

public class IsPowerOfFour {
	public boolean isPowerOfFour(int num) {

		return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
	}

	public static void main(String[] args) {
		IsPowerOfFour res = new IsPowerOfFour();
		if (res.isPowerOfFour(256)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
