package leetCode1;

public class PowerOfFour {
	public boolean isPowerOfFour(int num) {

		return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
	}

	public static void main(String[] args) {
		PowerOfFour res = new PowerOfFour();
		if (res.isPowerOfFour(256)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
