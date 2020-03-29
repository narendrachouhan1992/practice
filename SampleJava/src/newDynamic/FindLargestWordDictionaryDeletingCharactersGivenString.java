package newDynamic;

public class FindLargestWordDictionaryDeletingCharactersGivenString {
	boolean isSubSequence(String s1, String s2)
	{
		int j=0;
		for(int i=0;i<s2.length();i++)
		{
			if(j<s1.length() && s2.charAt(i) == s1.charAt(j))
			{
				j++;
			}
		}
		if(j== s1.length())
			return true;
		
		return false;
	}
	String getLargestWord(String[] words, String pat)
	{
		String sol = "";
		for(int i=0;i<words.length;i++)
		{
			if(isSubSequence(words[i], pat) && words[i].length()>sol.length())
			{
				sol = words[i];
			}
		}
		return sol;
	}
	public static void main(String[] args) {
		FindLargestWordDictionaryDeletingCharactersGivenString obj = new FindLargestWordDictionaryDeletingCharactersGivenString();
		String[] words = {"ale", "apple", "monkey", "plea"};
	    String str = "abpcplea" ;
		System.out.println(obj.getLargestWord(words, str));
	}
}
