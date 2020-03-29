package newDynamic;

public class PrintPossibleStringsCanMadePlacingSpaces {
	int counter = 1;
	void printAllString(String str, char[] buff, int i, int j)
	{
		if(i== str.length())
		{
			buff[j] = '\0';
			System.out.print(buff);
			System.out.println(" " + counter++);
			return;
		}
		buff[j] = str.charAt(i);
		printAllString(str, buff, i+1, j+1);
		buff[j] = ' ';
		buff[j+1] = str.charAt(i);
		printAllString(str, buff, i+1, j+2);
	}
	void printAllStrings(String str)
	{
		char[] buff = new char[str.length()*2];
		buff[0] = str.charAt(0);
		printAllString(str, buff, 1, 1);
	}
	public static void main(String[] args) {
		PrintPossibleStringsCanMadePlacingSpaces obj = new PrintPossibleStringsCanMadePlacingSpaces();
		obj.printAllStrings("ABCDEFG");
	}
}
