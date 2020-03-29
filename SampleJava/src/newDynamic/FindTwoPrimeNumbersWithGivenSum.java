package newDynamic;

public class FindTwoPrimeNumbersWithGivenSum {
	private boolean[] printAllPrimeTill(int n)
	{
		boolean[] arr = new boolean[n+1];
		for(int i=2;i<=n/2;i++)
		{
			int j =2;
			while(i*j<=n)
			{
				arr[i*j] = true;
				j++;
			}
		}
		return arr;
	}
	void printPrimeNum(int n)
	{
		boolean[] isPrime = printAllPrimeTill(n);
		for(int i=1;i<=n/2;i++)
		{
 			if(!isPrime[i] && !isPrime[n-i])
			{
				System.out.println(i + ", "+ (n-i));
			}
		}
	}
	public static void main(String[] args) {
		FindTwoPrimeNumbersWithGivenSum obj = new FindTwoPrimeNumbersWithGivenSum();
		obj.printPrimeNum(1000);
	}
}
