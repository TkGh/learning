package leetCode1;

import java.util.*;

public class moveZero
{

	public static void main(String[] args)
	{

		Scanner sc = new Scanner(System.in);
		System.out.print("Please:  ");
		String str = sc.nextLine();
		String s[] = str.split(" ");
		int[] num = new int[s.length];
		for (int i = 0; i < num.length; i++)
		{
			num[i] = Integer.parseInt(s[i]);
		}

		moveZeros(num);
	}

	public static void moveZeros(int[] nums)
	{
		int[] move = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
		{
			move[i] = nums[i];
		}
		for (int i = 0; i < move.length - 1; i++)
		{
			for (int j = 0; j < move.length - 1; j++)
			{
				if (move[j] == 0)
				{
					int temp = move[j];
					move[j] = move[j + 1];
					move[j + 1] = temp;
				}
			}
		}

		for (int e : move)
		{
			System.out.print(e);
			System.out.print("   ");
		}

	}
}
