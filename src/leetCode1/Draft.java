package leetCode1;

public class Draft {
	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 0; i < 10; i++) {
			a[i] = i;
		}

		int sum = 0;
		for (int e : a) {
			sum += e;
		}
		System.out.println(sum);
	}
}
