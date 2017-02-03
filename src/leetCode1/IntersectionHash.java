package leetCode1;

import java.util.*;

public class IntersectionHash
{
	public int[] intersection(int[] nums1, int[] nums2)
	{
		HashMap<Integer, Integer> inter = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums1.length; i++)
		{
			if (!inter.containsKey(nums1[i]))
			{
				inter.put(nums1[i], 1);
			}
		}

		ArrayList<Integer> temp = new ArrayList<Integer>();

		for (int i = 0; i < nums2.length; i++)
		{
			if (inter.containsKey(nums2[i]))
			{
				temp.add(nums2[i]);
				inter.remove(nums2[i]);
			}
		}

		int[] res = new int[temp.size()];
		for (int i = 0; i < temp.size(); i++)
		{
			res[i] = temp.get(i);
		}
	
		
		return res;
	}
}
