package newDynamic;

public class CountSumOfDigitsEqualsToGivenSumDyn {
	static int[][] lookup = new int[101][501];
	static int getNumberRec(int n,int sum)
	{
		if(n==0)
		{
			return (sum==0?1:0);
		}
		if(lookup[n][sum]!=-1)
			return lookup[n][sum];
		int answer=0;
		for (int i = 0; i < 10; i++) {
			answer+=getNumberRec(n-1, sum-i);
		}
		return lookup[n][sum] = answer;
		
	}
	static int getNumbers(int n, int sum)
	{
		for(int i=0;i<=100;i++)
			for(int j=0;j<=500;j++)
			{
				lookup[i][j] = -1;
			}
		int answer =0;
		for (int i = 1; i < 10; i++) {
			if(sum-i>=0)
			{
				answer += getNumberRec(n-1, sum-i);
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		int sum =5;
		int n =2;
		System.out.println(getNumbers(n,sum
				));
	}
}
