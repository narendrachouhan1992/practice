package newDynamic;

public class UnboundedKnapsackRepetitionItemsAllowed {
	int getMax(int[] w, int[] val, int W)
	{
		int[] dp = new int[W+1];
		int length = w.length;
		for(int i =0;i<=W;i++)
		{
			for(int j = 0;j<length;j++)
			{
				if(w[j]<=i)
				{
					dp[i] = Integer.max(val[j]+dp[i-w[j]], dp[i]);
				}
			}
		}
		
		return dp[W];
	}
	public static void main(String[] args) {
		int W = 100;
        int[] val = {10, 30, 20};
        int[] wt = {5, 10, 15};
        UnboundedKnapsackRepetitionItemsAllowed obj = new UnboundedKnapsackRepetitionItemsAllowed();
        System.out.println(obj.getMax(wt, val, W));
	}
}
