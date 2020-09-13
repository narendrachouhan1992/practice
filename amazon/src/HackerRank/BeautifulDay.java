package HackerRank;

import java.util.Stack;

public class BeautifulDay {
	static int beautifulDays(int i, int j, int k) 
	{
		int res = 0;
		for(int x=i;x<=j;x++)
		{
			int y = reverse(Integer.toString(x));
			int diff = Math.abs(y-x);
			if(diff%k==0)
				res++;
		}
		return res;
	}
	static int reverse(String s)
	{
		if(s==null)
			return 0;
		String rev = "";
		for(int i=s.length()-1;i>=0;i--)
		{
			rev+=s.charAt(i);
		}
		return Integer.parseInt(rev);
	}
}
