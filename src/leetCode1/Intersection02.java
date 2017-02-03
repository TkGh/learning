package leetCode1;

import java.util.ArrayList;
import java.util.Arrays;

public class Intersection02
{
	public static void main(String[] args)
	{
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		int[] result = interSection(nums1, nums2);
		for (int r : result)
		{
			System.out.println(r);
		}
	}

	public static int[] interSection(int[] nums1, int[] nums2)
	{
		int temp;
		int index1 = 0, index2 = 0;

		Arrays.sort(nums1);
		Arrays.sort(nums2);
		ArrayList<Integer> A = new ArrayList<Integer>();

		while (index1 < nums1.length && index2 < nums2.length)
		{
			if (nums1[index1] == nums2[index2])
			{
				temp = nums1[index1];
				A.add(temp);
				index1++;
				index2++;

			} else if (nums1[index1] < nums2[index2])
			{
				index1++;
			} else
			{
				index2++;
			}
		}
		int[] result = new int[A.size()];
		for (int i = 0; i < result.length; i++)
		{
			result[i] = A.get(i);
		}
		return result;
	}
}
