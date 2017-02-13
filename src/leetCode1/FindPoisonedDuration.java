package leetCode1;

public class FindPoisonedDuration {
	public int findPoisonedDuration(int[] timeSeries, int duration) {
		if (timeSeries.length == 0) {
			return 0;
		}

		if (timeSeries.length == 1) {
			return duration;
		}

		int size = timeSeries.length;
		int res = 0;
		int start = 0;
		for (int i = 0; i < size; i++) {
			if (timeSeries[i] < timeSeries[start] + duration) {
				res += timeSeries[i] - timeSeries[start];
				start = i;
			} else {
				res += duration;
				start = i;
			}
		}

		return res + duration;
	}

	public static void main(String[] args) {
		int[] a = {1};
		FindPoisonedDuration b = new FindPoisonedDuration();
		System.out.println(b.findPoisonedDuration(a, 2));
	}
}
