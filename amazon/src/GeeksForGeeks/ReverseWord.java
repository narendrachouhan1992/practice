package GeeksForGeeks;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWord {
	static String reverse(String str)
	{
		return Arrays.stream(str.split(" ")).map(s->revWord(s)).collect(Collectors.joining(" "));
	}
	private static String revWord(String str)
	{
		if(str==null || str.length()<=1)
			return str;
		StringBuilder sb = new StringBuilder();
		for(int i=str.length()-1;i>=0;i--)
		{
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		String word = "The cat in the hat";
		System.out.println(word);
		System.out.println(reverse(word));
	}
}
