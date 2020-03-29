package newDynamic;

public class FindPossibleWordsPhoneDigits {
	 final String[] hashTable = {"", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"};
	void printWords(int num)
	{
		char[] nums = Integer.toString(num).toCharArray();
		printUntill(nums, "", 0);
	}
	void printUntill(char[] num,String curr ,int start)
	{
		if(num.length == start)
		{
			System.out.println(curr);
		}
		else
		{
			int i = num[start] - '0';
			for(int j =0;j<hashTable[i].length();j++)
			{
				printUntill(num, curr + hashTable[i].charAt(j), start+1);
			}
		}
		
	}
	public static void main(String[] args) {
		FindPossibleWordsPhoneDigits obj = new FindPossibleWordsPhoneDigits();
		obj.printWords(9);
	}
}
