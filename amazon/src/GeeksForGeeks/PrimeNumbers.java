package GeeksForGeeks;

import java.util.Arrays;

public class PrimeNumbers {
	static void getprimeSum(int n)
	{
		boolean[] prime = new boolean[n+1];
		Arrays.fill(prime, true);
		for(int p=2;p*p<=n;p++)
		{
			if (prime[p] == true) 
			{ 
				for (int i = 2; i*p <= n; i ++) 
					prime[i*p] = false; 
            } 
        }
		for(int i=1;i<=n;i++)
		{
			if(prime[i])
				System.out.println(i);
		}
	}
	public static void main(String[] args) {
	
		getprimeSum(100);
	}
}
