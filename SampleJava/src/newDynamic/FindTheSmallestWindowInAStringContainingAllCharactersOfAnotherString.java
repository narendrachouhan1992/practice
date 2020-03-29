package newDynamic;

public class FindTheSmallestWindowInAStringContainingAllCharactersOfAnotherString {
	String getMin(String str, String pat)
	{
		int[] str_hash = new int[256];
		int[] pat_hash = new int[256];
		int count = 0;
		int start = 0;
		int start_index = -1;
		int min_len = str.length();
		for(int i = 0;i<pat.length();i++)
		{
			pat_hash[pat.charAt(i)] ++;
		}
		for(int i = 0;i<str.length();i++)
		{
			str_hash[str.charAt(i)]++;
			if(pat_hash[str.charAt(i)]!= 0 && str_hash[str.charAt(i)]<=pat_hash[str.charAt(i)])
			{
				count ++;
			}
			if(count == pat.length())
			{
				while(pat_hash[str.charAt(start)] == 0 
				|| str_hash[str.charAt(start)] > pat_hash[str.charAt(start)])
				{
					 if (str_hash[str.charAt(start)] > pat_hash[str.charAt(start)])
						 str_hash[str.charAt(start)]--;
					start++;
				}
				
				int len_window = i - start + 1;
                if (min_len > len_window)
                {
                    min_len = len_window;
                    start_index = start;
                }
			}
		}
		return str.substring(start_index, start_index+min_len);
	}
	public static void main(String[] args) {
		String str = "this is a test string";
        String pat = "tist";
	    FindTheSmallestWindowInAStringContainingAllCharactersOfAnotherString obj = new FindTheSmallestWindowInAStringContainingAllCharactersOfAnotherString();
	    System.out.println(obj.getMin(str, pat));
	}
}
