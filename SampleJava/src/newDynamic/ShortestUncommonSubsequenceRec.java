package newDynamic;

public class ShortestUncommonSubsequenceRec {
	static int  MAX=10000;
	int getSmallestUncommonSubstringLength(String s1, String s2)
	{
		if(s1.length()==0)
			return MAX;
		if(s2.length()<=0)
			return 1;
		int l2 = s2.length();
		int i;
		for(i =0;i<l2;i++)
		{
			if(s1.charAt(0)==s2.charAt(i))
				break;
		}
		if(i == s2.length())
			return 1;
		return Integer.min(getSmallestUncommonSubstringLength(s1.substring(1), s2), 1 +getSmallestUncommonSubstringLength(s1.substring(1), s2.substring(i+1)));
	}
	public static void main(String[] args) {
		 String s1 = "babab";
		 String s2 = "babba";
		 ShortestUncommonSubsequenceRec obj = new ShortestUncommonSubsequenceRec();
		 System.out.println(obj.getSmallestUncommonSubstringLength(s1, s2));
		    
	}
}
