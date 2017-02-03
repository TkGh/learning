package leetCode1;

public class fibonaccI
{
	public int fibonacci(int n)
	{
		int tempa = 0, tempb = 1;
		for (int i = 0; i < n; i++)
		{
			if (i % 2 == 0)
			{
				tempa += tempb;
			} else
			{
				tempb += tempa;
			}
		}

		int y = 0;
		if (n % 2 == 0)
		{
			y = tempb;
		} else
		{
			y = tempa;
		}
		return y;
	}
}
