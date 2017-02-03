package leetCode1;

import java.util.*;

public class mergeSortedArray {
	public int[] merge(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		ArrayList<Integer> R = new ArrayList<>();

		int indexa = 0, indexb = 0;

		while (indexa < A.length && indexb < B.length) {
			if (A[indexa] == B[indexb]) {

				R.add(A[indexa]);
				R.add(B[indexb]);
				indexa++;
				indexb++;
			} else if (A[indexa] < B[indexb]) {
				R.add(A[indexa]);
				indexa++;
			} else {
				R.add(B[indexb]);
				indexb++;
			}
		}

		while (indexb < B.length) {
			R.add(B[indexb]);
			indexb++;
		}
		while (indexa < A.length) {
			R.add(A[indexa]);
			indexa++;
		}

		int[] result = new int[R.size()];

		for (int i = 0; i < result.length; i++) {
			result[i] = R.get(i);
		}
		return result;

	}
}
