package newDynamic;

import java.util.HashMap;
import java.util.Map;

public class PrintStringIgnoringAlternateOccurrencesCharacter {
	void printIgnoredNextChar(String str)
	{
		Map<Character, Boolean> map = new HashMap<Character, Boolean>();
		int length = str.length();
		for(int i =0;i<length;i++)
		{
			if(map.get(str.charAt(i)) == null || map.get(str.charAt(i)) == false)
			{
				System.out.print(str.charAt(i));
				map.put(str.charAt(i), true);
			}
			else
			{
				map.remove(str.charAt(i));
			}
		}
	}
	public static void main(String[] args) {
		PrintStringIgnoringAlternateOccurrencesCharacter obj = new PrintStringIgnoringAlternateOccurrencesCharacter();
        String str1 = "Geeks for geeks";
        String str2 = "It is a long day Dear";
		obj.printIgnoredNextChar(str1);
		System.out.println();
		obj.printIgnoredNextChar(str2);
	}
}
