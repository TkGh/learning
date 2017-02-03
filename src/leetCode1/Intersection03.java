package leetCode1;

import java.util.*;

public class Intersection03
{
	public static void main(String[] args)
	{
		int[] nums1 = { 4, 7, 9, 7, 6, 7 };
		int[] nums2 = { 5, 0, 0, 6, 1, 6, 2, 2, 4 };
		int[] result = interSection(nums1, nums2);
		for (int r : result)
		{
			System.out.println(r);
		}
	}

	public static int[] interSection(int[] nums1, int[] nums2)
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();

		for (int i = 0; i < nums1.length; i++)
		{
			a.add(nums1[i]);
		}

		for (int i = 0; i < nums2.length; i++)
		{
			b.add(nums2[i]);
		}

		a.retainAll(b);
		Set<Integer> temp = new HashSet<>();

		for (int i = 0; i < a.size(); i++)
		{
			temp.add(a.get(i));
		}

		int[] result = new int[temp.size()];
		Iterator<Integer> iter = temp.iterator();
		int i = 0;
		while (iter.hasNext() && i < result.length)
		{
			result[i] = (int) iter.next();
			i++;
		}

		return result;
	}
}