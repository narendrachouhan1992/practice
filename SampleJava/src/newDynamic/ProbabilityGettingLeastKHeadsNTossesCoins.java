package newDynamic;

public class ProbabilityGettingLeastKHeadsNTossesCoins {
	double[] dp = new double[100000];
	void precalculate()
	{
		for(int i =2;i<100000;i++)
		{
			dp[i] = dp[i-1]+ Math.log(i)/Math.log(2);
		}
	}
	double getExactProbability(int k, int n)
	{
		double val = dp[n]-dp[k]-dp[n-k]-n;
		return Math.pow(2, val);
	}
	double getAtleastProbability(int k, int n)
	{
		double ans = 0;
		for(int i=k;i<=n;i++)
		{
			double val = dp[n]-dp[i]-dp[n-i]-n;
			ans+= Math.pow(2, val);
		}
		return ans;
		
	}
	public static void main(String[] args) {
		ProbabilityGettingLeastKHeadsNTossesCoins obj = new ProbabilityGettingLeastKHeadsNTossesCoins();
		obj.precalculate();
		System.out.println(obj.getAtleastProbability(2, 3));
		System.out.println(obj.getAtleastProbability(3, 6));
		System.out.println(obj.getAtleastProbability(500, 1000));
	}
}
