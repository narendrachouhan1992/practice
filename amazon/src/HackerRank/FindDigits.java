package HackerRank;

public class FindDigits {
	static int findDigits(int n)
	{
		String ns = Integer.toString(n);
		int count = 0;
		for(int i=0;i<ns.length();i++)
		{
			if(ns.charAt(i)!='0' && n%(ns.charAt(i)-'0')==0)
				count++;
		}
		return count;
	}
}
