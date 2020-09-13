package HackerRank.StringMenipitaion;

public class CommonChild {
	static int commonChild(String s1, String s2) {

		int m = s1.length();
		int n = s2.length();
		int L[][] = new int[m + 1][n + 1];

		/*
		 * Following steps build L[m+1][n+1] in bottom up fashion. Note that L[i][j]
		 * contains length of LCS of X[0..i-1] and Y[0..j-1]
		 */
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (s1.charAt(i - 1) == s2.charAt(j - 1))
					L[i][j] = L[i - 1][j - 1] + 1;
				else
					L[i][j] = Integer.max(L[i - 1][j], L[i][j - 1]);
			}
		}
		return L[m][n];
	}

	int lcs(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int L[][] = new int[m + 1][n + 1];

		/*
		 * Following steps build L[m+1][n+1] in bottom up fashion. Note that L[i][j]
		 * contains length of LCS of X[0..i-1] and Y[0..j-1]
		 */
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (s1.charAt(i - 1) == s2.charAt(j - 1))
					L[i][j] = L[i - 1][j - 1] + 1;
				else
					L[i][j] = Integer.max(L[i - 1][j], L[i][j - 1]);
			}
		}
		return L[m][n];
	}
}
