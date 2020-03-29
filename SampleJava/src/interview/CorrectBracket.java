package interview;

public class CorrectBracket {
	static boolean isBalanced(String expression)
	{
		
		int size = expression.length();
		int[] arr = new int[size];
		int pos=-1;
		for(int i=0;i<size;i++)
		{
			if(expression.charAt(i) == '{' || expression.charAt(i) == '(' || expression.charAt(i) == '[')
			{
				arr[++pos] = expression.charAt(i);
			}
			else
			{
				if(pos==-1)
				{
					return false;
				}
				else if(arr[pos]== '[' && expression.charAt(i) == ']')
				{
					pos--;
				}
				else if(arr[pos]== '{' && expression.charAt(i) == '}')
				{
					pos--;
				}
				else if(arr[pos]== '(' && expression.charAt(i) == ')')
				{
					pos--;
				}
				else
				{
					return false;
				}
			}
		}
		if(pos == -1)
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		String str = "[{()()[]}]";
		String str1 = "[][][{]}";
		if(isBalanced(str))
		{
			System.out.println("correct");
		}
		else
		{
			System.out.println("incorrect");
		}
		if(isBalanced(str1))
		{
			System.out.println("correct");
		}
		else
		{
			System.out.println("incorrect");
		}
	}
}
