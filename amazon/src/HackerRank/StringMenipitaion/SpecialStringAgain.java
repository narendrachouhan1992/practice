package HackerRank.StringMenipitaion;

public class SpecialStringAgain {
	static long substrCount1(int n, String s) {
		boolean[][] dp = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = true;
		}
		int count = s.length();
		for (int length = 2; length <= s.length(); length++) {
			for(int i =0;i<=s.length()-length;i++)
			{
				int j = i+length-1;
				if(length==2 && s.charAt(i)==s.charAt(j))
					dp[i][j] = true;
				else if(length!=2 && (s.charAt(i)==s.charAt(j))&& dp[i+1][j-1])
					dp[i][j] = true;
				
				if(dp[i][j])
					count++;
			}
		}
		return count;
	}
	static long substrCoun1t(int n, String s) {
		
		if(s== null || n == 0)
			return 0;
		boolean[][] dp = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = true;
		}
		long count = s.length();
		for (int length = 2; length <= s.length(); length++) {
			for(int i =0;i<=s.length()-length;i++)
			{
				int j = i+length-1;
				if((length==2 || length==3) && s.charAt(i)==s.charAt(j))
					dp[i][j] = true;
				else if(length>3 && (s.charAt(i)==s.charAt(j) && s.charAt(i)==s.charAt(i+1))&& dp[i+1][j-1])
					dp[i][j] = true;
				
				if(dp[i][j])
					count++;
			}
		}
		return count;
	}
	static long substrCount(int n, String s)
    {
        long retVal = s.length();

        for (int i = 0; i < s.length(); i++)
        {
            long startChar = s.charAt(i);
            int diffCharIdx = -1;
            for (int j = i + 1; j < s.length(); j++)
            {
                int currChar = s.charAt(j);
                if (startChar == currChar)
                {
                    if ((diffCharIdx == -1) ||
                       (j - diffCharIdx) == (diffCharIdx - i))
                        retVal++;
                }
                else
                {
                    if (diffCharIdx == -1)
                        diffCharIdx = j;
                    else
                        break;
                }
            }
        }
        return retVal;
    }
	public static void main(String[] args) {
	}

}