package leetCode1;

/**
 * Given a positive integer number, write a function which returns True if
 * number is a perfect square else False.
 * 
 * Note: Do not use any built-in library function such as square root.
 *
 */
public class IsPerfectSquare {
	public boolean isPerfectSquare(int num) {
		int length = num / 2 + 1;
		while (length > 0) {
			if (num == length * length) {
				return true;
			}
			length--;
		}
		return false;
	}

	public static void main(String[] args) {
		IsPerfectSquare res = new IsPerfectSquare();
		if (res.isPerfectSquare(65536)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
