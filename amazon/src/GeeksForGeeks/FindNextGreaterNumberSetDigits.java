package GeeksForGeeks;

import java.util.Arrays;

public class FindNextGreaterNumberSetDigits {
	static int findNextNumer(int n)
	{
		char[] num = Integer.toString(n).toCharArray();
		int length = num.length;
		int i;
		for(i=length-2;i>=0;i--)
		{
			if(num[i]>num[i+1])
			{
				i--;
			}
			else
				break;
		}
		if(i==-1)
			return -1;
		char a = num[i];
		num[i] = num[length-1];
		num[length-1] = a;
		Arrays.parallelSort(num, i+1, length-1);
		return Integer.parseInt(new String(num));
	}
	public static void main(String[] args) {
		System.out.println(findNextNumer(534976));
	}
}
