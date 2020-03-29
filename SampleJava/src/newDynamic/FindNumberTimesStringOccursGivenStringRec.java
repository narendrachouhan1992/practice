package newDynamic;

public class FindNumberTimesStringOccursGivenStringRec {
	int getNumberOfWays (String str1, String str2, int m, int n)
	{
		if(n==0)
			return 1;
		if(m==0)
			return 0;
		if(str1.charAt(m-1) == str2.charAt(n-1))
		{
			return (getNumberOfWays(str1, str2, m-1, n-1) + getNumberOfWays(str1, str2, m-1, n));
		}
		else
		{
			return getNumberOfWays(str1, str2, m-1, n);
		}
	}
	public static void main(String[] args) {
		String a = "GeeksforGeeks";
	    String b = "Gks";
	    FindNumberTimesStringOccursGivenStringRec obj = new FindNumberTimesStringOccursGivenStringRec();
	    System.out.println(obj.getNumberOfWays(a, b, a.length(), b.length()));
	}
}
