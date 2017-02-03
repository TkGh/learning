package leetCode1;

import java.util.*;

public class IsHappy
{
	public static void main(String[] args)
	{
		int a = 11111;
		if (IsHappy.isHappy(a))
		{
			System.out.println("Yes!");
		} else
		{
			System.out.println("No!");
		}

	}

	public static boolean isHappy(int n)
	{
		ArrayList<Integer> b = new ArrayList<Integer>();
		while (n > 0)
		{
			int temp = 0;

			b.add(1);
			while (n > 0)
			{
				temp += (n % 10) * (n % 10);
				n = n / 10;
			}
			if (temp == 1)
			{
				return true;
			} else
			{
				for (int i = 0; i < b.size(); i++)
				{
					if (temp == b.get(i))
					{
						return false;
					}
				}
				b.add(temp);
				n = temp;
			}
		}

		return false;
	}
}
