package leetCode1;

public class TwoSum
{
	public int[] twoSum(int[] numbers, int target)
	{
		int[] res = new int[2];

		for (int i = 0; i < numbers.length - 1; i++)
		{
			for (int j = i + 1; j < numbers.length; j++)
			{
				if (target - numbers[i] == numbers[j])
				{
					res[0] = i ;
					res[1] = j ;
				}
			}
		}
		return res;
	}
}
