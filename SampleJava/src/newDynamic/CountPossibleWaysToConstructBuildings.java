package newDynamic;

public class CountPossibleWaysToConstructBuildings {
	static int getNumberOfWays(int n)
	{
		if(n==1)
			return 4;
		int countB = 1;
		int countA = 1;
		int countA_prev;
		int countB_prev;
		for(int i=2;i<=n;i++)
		{
			countA_prev = countA;
			countB_prev = countB;
			
			countA = countA_prev+countB_prev;
			countB = countA_prev;
		}
		int result = countA+countB;
		return (result*result);
	}
	
	public static void main(String[] args) {
		System.out.println(getNumberOfWays(3));
	}
}
