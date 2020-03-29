package airtelPayment;

public class NonRepeatingCharOfString {
	char getFirstNonRepeat1(String str)
	{
		int[] charCount = new int[256];
		int length = str.length();
		for(int i=0;i<length;i++)
		{
			charCount[str.charAt(i)] ++;
		}
		int i;
		for(i=0;i<length;i++)
		{
			if(charCount[str.charAt(i)] == 1)
			{
				return str.charAt(i);
			}
		}
		return ' '; // case where no non repeating char is there
	}
}
