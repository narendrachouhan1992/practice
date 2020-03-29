package newDynamic;

public class WriteACProgramToPrintAllPermutationsOfAGivenString {
	String swap(String str, int i, int j)
	{
		if(i<0 || i >= str.length() || j<0 || j >= str.length())
			return str;
		char temp = str.charAt(i);
		char[] tempArr = str.toCharArray();
		tempArr[i]= tempArr[j];
		tempArr[j] = temp;
		return String.valueOf(tempArr);
	}
	void printAllPC(String str, int l ,int r)
	{
		if(l==r)
			System.out.println(str);
		for(int i =l; i<=r;i++)
		{
			str = swap(str, l, i);
			printAllPC(str, l+1, r);
			str = swap(str, l, i);
		}
		 
	}
	public static void main(String[] args) {
		WriteACProgramToPrintAllPermutationsOfAGivenString obj = new WriteACProgramToPrintAllPermutationsOfAGivenString();
		String str = "qwerty";
		obj.printAllPC(str, 0, str.length()-1);
	}
}
