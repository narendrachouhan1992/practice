package newDynamic;

public class FindMinimumNumberOfCoinsThatMakeAChange {
	int getMinNum(int[] coints, int value)
	{
		int[] dp = new int[value+1];
		for(int i =1;i<= value;i++)
		{
			dp[i]= Integer.MAX_VALUE;
		}
		for(int i =1;i<= value;i++)
		{
			for(int j = 0;j<coints.length;j++)
			{
				if(coints[j]<=i && dp[i-coints[j]]!= Integer.MAX_VALUE)
				{
					dp[i] = Integer.min(dp[i], dp[i-coints[j]]+1);
				}
			}
		}
		return dp[value];
	}
	public static void main(String[] args) {
		FindMinimumNumberOfCoinsThatMakeAChange obj = new FindMinimumNumberOfCoinsThatMakeAChange();
		int coins[] = {9, 6, 5, 1};
		System.out.println(obj.getMinNum(coins, 11));
	}
}
