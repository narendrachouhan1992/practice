package newDynamic;

import java.util.ArrayList;
import java.util.List;

public class FindFirstNonRepeatingCharacterStreamCharacters {
	void printFirstNonRepeating(String input)
	{
		List<Character> dll = new ArrayList<Character>();
		boolean[] isRepeated = new boolean[256];
		int length = input.length();
		for(int i=0;i<length;i++)
		{
			char c = input.charAt(i);
			System.out.println("Reading charactor "+ c);
			if(!isRepeated[c])
			{
				if(dll.contains(c))
				{
					dll.remove((Character)c);
					isRepeated[c] = true;
				}
				else
				{
					dll.add(c);
				}
			}
			if(!dll.isEmpty())
				System.out.println("repeated character is "+ dll.get(0));
		}
	}
	public static void main(String[] args) {
		FindFirstNonRepeatingCharacterStreamCharacters obj = new FindFirstNonRepeatingCharacterStreamCharacters();
		String input = "geeksforgeeksandgeeksquizfor";
		obj.printFirstNonRepeating(input);
	}
}
