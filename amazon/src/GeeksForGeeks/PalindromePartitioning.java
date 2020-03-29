package GeeksForGeeks;

public class PalindromePartitioning {
	static int getPartition(String s)
	{
		if(s==null || s.length()==0)
		return 0;
		int  n = s.length();
		boolean[][] P = new boolean[n][n];
		int[][] C = new int[n][n];
		
		for(int i=0;i<n;i++)
		{
			C[i][i] = 0;
			P[i][i] = true;
		}
		
		for(int L=2;L<=n;L++)
		{
			for(int i=0;i<n-L+1;i++)
			{
				int j = i+L-1;
				
				if(L==2)
				{
					P[i][j] = (s.charAt(i)==s.charAt(j));
				}
				else
				{
					P[i][j] = (s.charAt(i)==s.charAt(j) && P[i+1][j-1]);
				}
				
				C[i][j] = Integer.MAX_VALUE;
				if(P[i][j])
				{
					C[i][j]=0;
				}
				else
				{
					for(int k=i;k<j;k++)
					{
						C[i][j]= Integer.min(C[i][j], 1+C[i][k]+C[k+1][j]);
					}
				}
			}
		}
		return C[0][n-1];
	}
	public static void main(String[] args) {
		System.out.println(getPartition("ababbbabbababa"));
	}
	
}
