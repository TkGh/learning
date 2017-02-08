package leetCode1;

import java.util.ArrayList;

public class Merge {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int size = n + m - 1;
		int size1 = m - 1;
		int size2 = n - 1;

		while (size1 >= 0 && size2 >= 0) {
			if (nums1[size1] < nums2[size2]) {
				nums1[size] = nums2[size2];
				size--;
				size2--;
			} else {
				nums1[size] = nums1[size1];
				size--;
				size1--;
			}
		}

		while (size2 >= 0) {
			nums1[size] = nums2[size2];
			size--;
			size2--;
		}
	}
}
