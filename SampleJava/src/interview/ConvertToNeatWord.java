package interview;

import java.util.Arrays;

public class ConvertToNeatWord {
	static int[] minimalOperations(String[] words)
	{
		
		int result[] = new int[words.length];
		for(int x = 0;x<words.length;x++)
		{
			String word = words[x];
			int length = word.length();
			int res = 0;
			for(int i=1;i<length;i++)
			{
				int reapCount = 1;
				while(i<word.length() &&  word.charAt(i) == word.charAt(i-1))
				{
					i++;
					reapCount++;
				}
				if(reapCount%2 == 1)
				{
					reapCount--;
				}
				res += (reapCount/2);	
			}
			result[x] = res;
		}
		
		return result;
	}
	public static void main(String[] args) {
		String[] str = {"ab", "aab", "abb", "abab", "abaaaba"};
		System.out.println(Arrays.toString(minimalOperations(str)));
	}
}
