package newDynamic;

public class NumberSubsequencesFormAiBjCk {
	int getCount(String word)
	{
		int aCount = 0;
		int bCount = 0;
		int cCount = 0;
		int length = word.length();
		for(int i=0;i<length;i++)
		{
			if(word.charAt(i) == 'a')
				aCount = (1+ 2*aCount);
			if(word.charAt(i) == 'b')
				bCount = (aCount+ 2*bCount);
			if(word.charAt(i) == 'c')
				cCount = (bCount + 2*cCount);
		}
		return cCount;
	}
	public static void main(String[] args) {
		String s = "abbc";
		NumberSubsequencesFormAiBjCk obj = new NumberSubsequencesFormAiBjCk();
        System.out.println(obj.getCount(s));
	}
	
}
