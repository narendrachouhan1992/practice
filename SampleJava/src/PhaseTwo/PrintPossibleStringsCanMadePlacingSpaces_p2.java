package PhaseTwo;

public class PrintPossibleStringsCanMadePlacingSpaces_p2 {
	
	void printUntill(String str,char[] buff,int i,int j,int n)
	{
		if(i==n)
		{
			buff[j] = '\0';
			System.out.println(buff);
			return;
		}
		buff[j]= str.charAt(i);
		printUntill(str, buff, i+1, j+1, n);
		
		buff[j] = ' ';
		buff[j+1] = str.charAt(i);
		printUntill(str, buff, i+1, j+2, n);
	}
	void printPermutation(String str)
	{
		char[] buff = new char[2*str.length()];
		buff[0] = str.charAt(0);
		printUntill(str, buff, 1,1,str.length());
	}
	public static void main(String[] args) {
		PrintPossibleStringsCanMadePlacingSpaces_p2 obj = new PrintPossibleStringsCanMadePlacingSpaces_p2();
		obj.printPermutation("ABCD");
	}
}
