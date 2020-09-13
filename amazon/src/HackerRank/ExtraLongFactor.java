package HackerRank;

import java.math.BigInteger;

public class ExtraLongFactor {
	static void extraLongFactorials(int n) 
	{	
		BigInteger d = factorial(n);
		
		System.out.println(d);
	}
	static BigInteger factorial (int n)
	{
		if(n==0 || n==1)
			return BigInteger.ONE;
		return factorial(n-1).multiply(BigInteger.valueOf(n));
	}
	public static void main(String[] args) {
		extraLongFactorials(25);
	}
}
