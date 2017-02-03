package leetCode1;

public class IsUgly {
	public static void main(String[] args) {
		IsUgly a = new IsUgly();
		if (a.isUgly(8)) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}

	public IsUgly() {

	}

	public boolean isUgly(int num) {
		if (num <= 0) {
			return false;
		}

		int[] temp = {2, 3, 5};

		while (num > 1) {
			int i = 0;
			for (i = 0; i < 3; i++) {
				if (num % temp[i] == 0) {
					num /= temp[i];
					break;
				}
			}
			if (i == 3) {
				return false;
			}
		}

		return num == 1;
	}

}
