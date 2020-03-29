package newDynamic;

public class LengthOfTheLongestSubstringWithoutRepeatingCharacters {
	int printLongestString(String str)
	{
		int[] hash = new int[256];
		int max_length = 1;
		int curr_length = 1;
		for(int i=0;i<256;i++)
		{
			hash[i] = -1;
		}
		int length = str.length();
		hash[str.charAt(0)] = 0;
		for(int i=1;i<length;i++)
		{
			int prev_index = hash[str.charAt(i)];
			if(prev_index == -1 || prev_index+curr_length< i )
			{
				curr_length++;
			}
			else
			{
				if(curr_length>max_length)
					max_length = curr_length;
				curr_length = i-prev_index;
			}
			hash[str.charAt(i)] = i;
		}
		return max_length;
	}
	public static void main(String[] args) {
		LengthOfTheLongestSubstringWithoutRepeatingCharacters obj = new LengthOfTheLongestSubstringWithoutRepeatingCharacters();
		String str = "ABDEFGABEF";
		System.out.println(obj.printLongestString(str));
	}
}
