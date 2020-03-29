package newDynamic;

public class CountPalindromicSubsequenceGivenStringRec {
	int countPS(String str, int start, int end)
	{
		if(start>end)
			return 0;
		if(start==end)
			return 1;
		else if(str.charAt(start)== str.charAt(end))
			return (countPS(str, start+1, end)+ countPS(str, start, end-1)+ 1);
		else
			return (countPS(str, start+1, end)+ countPS(str, start, end-1) - countPS(str, start+1, end-1));
	}
	public static void main(String[] args) {
		CountPalindromicSubsequenceGivenStringRec obj = new CountPalindromicSubsequenceGivenStringRec();
		String str = "abcb";
		System.out.println(obj.countPS(str, 0, str.length()-1));
	}
}
