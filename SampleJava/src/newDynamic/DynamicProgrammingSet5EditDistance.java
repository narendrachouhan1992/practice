package newDynamic;

public class DynamicProgrammingSet5EditDistance {
	int min(int a, int b, int c)
	{
		return Integer.min(Integer.min(a, b), c);
	}
	int getCost(String str1, String str2, int m, int n)
	{
		if(n==0)
			return m;
		if(m==0)
			return n;
		if(str1.charAt(m-1)== str2.charAt(n-1))
			return getCost(str1, str2, m-1, n-1);
		else
		{
			return 1 + min(getCost(str1, str2, m-1, n-1), 
					getCost(str1, str2, m, n-1),
					getCost(str1, str2, m-1, n));
		}
	}
	public static void main(String[] args) {
		DynamicProgrammingSet5EditDistance obj = new DynamicProgrammingSet5EditDistance();
		String str1 = "sunday";
        String str2 = "saturday";
		System.out.println(obj.getCost(str1, str2, str1.length(), str2.length()));
	}
}
