package newDynamic;

import java.util.Arrays;

public class FactorialLargeNumber {
	void getFactorial(int n)
	{
		int[] res = new int[500];
		int size = 1;
		res[0] = 1;
		for(int i=2;i<=n;i++)
		{
			size  = multiply(res, size, i);
		}
		System.out.println("factorial is :");
		for(int i=size-1;i>=0;i--)
		{
			System.out.print(res[i]);
		}
	}
	int multiply(int[] res, int size, int n)
	{
		int carry = 0;
		for(int i = 0;i<size;i++)
		{
			int prod = res[i]*n + carry;
			res[i] = prod%10;
			carry = prod/10;
		}
		while(carry!= 0)
		{
			res[size++] = carry%10;
			carry /= 10;
		}
		return size;
	}
	public static void main(String[] args) {
		FactorialLargeNumber obj = new FactorialLargeNumber();
		obj.getFactorial(100);
	}
}
