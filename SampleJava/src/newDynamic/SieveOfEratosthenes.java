package newDynamic;

public class SieveOfEratosthenes {
	void printAllPrimeTill(int n)
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
		for(int i=1;i<=n;i++)
		{
			if(!arr[i])
			{
				System.out.print(i + ", ");
			}
		}
	}
	public static void main(String[] args) {
		SieveOfEratosthenes obj = new SieveOfEratosthenes();
		obj.printAllPrimeTill(50);
	}
}
