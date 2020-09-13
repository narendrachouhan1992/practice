package HackerRank;

public class ARepetation {
	static long repeatedString(String s, long n) 
	{
		long fx = (long) Math.floor(n/s.length());
		long rem = n%s.length();
		long count = 0;
		for(int i =0;i<s.length();i++)
		{
			if(s.charAt(i)=='a')
				count++;
			if(rem==i-1)
				rem = count;
		}
		count*=fx;
		count+=rem;
		return count;
	}
	public static void main(String[] args) {
		System.out.println(repeatedString("a", 1000000000000L));
	}
}
