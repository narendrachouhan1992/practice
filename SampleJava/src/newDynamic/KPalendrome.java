package newDynamic;

public class KPalendrome {
	int getNumberOfDeletionForPalendrome(String str1, String str2, int m, int n)
	{
		if(m==0)
			return n;
		if(n==0)
			return m;
		if(str1.charAt(m-1) == str2.charAt(n-1))
			return getNumberOfDeletionForPalendrome(str1, str2, m-1, n-1);
		return (1+ Integer.min(getNumberOfDeletionForPalendrome(str1, str2, m-1, n), getNumberOfDeletionForPalendrome(str1, str2, m, n-1)));
	}
	boolean isKPelendrome(String str, int k)
	{
		StringBuffer str2 = new StringBuffer(str);
		str2.reverse();
		String str2New = str2.toString();
		int changeReq = getNumberOfDeletionForPalendrome(str, str2New, str.length(), str2New.length());
		if(changeReq<= 2*k)
		return true;
		
		return false;
	}
	public static void main(String[] args) {
		String input = "acdcb";
		int k = 2;
		KPalendrome obj = new KPalendrome();
		if(obj.isKPelendrome(input, k))
			{
			System.out.println("yes");
			}
	}
}
