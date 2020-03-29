package newDynamic;

public class BuildLowestNumberByRemovingNDigitsFromAGivenNumber {
	public String getMinNumRec(String input, int n, String  res)
	{
		if(n==0)
		{
			res = res.concat(input);
			return res;
		}
		int len = input.length();
		if(len<= n)
		{
			return res;
		}
		int min_index = 0;
		for(int i =1;i<=n;i++)
		{
			if(input.charAt(i)< input.charAt(min_index))
			{
				min_index = i;
			}
		}
		res = res.concat(Character.toString(input.charAt(min_index)));
		String new_input = input.substring(min_index+1);
		return getMinNumRec(new_input, n - min_index, res);
		
	}
	public String getMinNum(String str,int n)
	{
		String res = "";
		return  getMinNumRec(str, n, res);
	}
	public static void main(String[] args) {
		String input = "121198";
		BuildLowestNumberByRemovingNDigitsFromAGivenNumber obj = new BuildLowestNumberByRemovingNDigitsFromAGivenNumber();
		System.out.println(input);
		System.out.println(obj.getMinNum(input, 2));
	}
}
