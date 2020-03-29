package geeksForGeeks;

public class UnboundedKnapsackRepetitionItemsAllowed {
	int getMax(int[] w, int[] v, int c) {
		int[] dp = new int[c + 1];
		int n = v.length;
		for (int i = 0; i <= c; i++) {
			for (int j = 0; j < n; j++) {
				if (w[j] <= i) {
					dp[i] = Integer.max(dp[i], dp[i - w[j]] + v[j]);
				}
			}
		}
		return dp[c];
	}

	public static void main(String[] args) {
		int W = 100;
		int val[] = { 10, 30, 20 };
		int wt[] = { 5, 10, 15 };
		UnboundedKnapsackRepetitionItemsAllowed obj = new UnboundedKnapsackRepetitionItemsAllowed();
		System.out.println(obj.getMax(wt, val, W));
	}
}
