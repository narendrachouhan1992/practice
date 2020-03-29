package newDynamic;

public class ExtractMaximumNumericValueGivenString {
	void printMaxValue(String str)
	{
		String max = "0";
		String curr = "";
		int length = str.length();
		int i =0;
		while(i<length)
		{
			if(i<length && !Character.isDigit(str.charAt(i)))
			{
				i++;
			}
			else
			{
				while(i<length && str.charAt(i) == '0')
				{
					i++;
				}
				while(i<length && Character.isDigit(str.charAt(i)))
				{
					curr += str.charAt(i++);
				}
				if(Integer.parseInt(curr)>Integer.parseInt(max))
				{
					max = curr;
				}
				curr = "";
			}
		}
		System.out.println(max);
	}
	public static void main(String[] args) {
		ExtractMaximumNumericValueGivenString obj = new ExtractMaximumNumericValueGivenString();
		String str = "100klh564abc365bg";
		obj.printMaxValue(str);
	}
}
