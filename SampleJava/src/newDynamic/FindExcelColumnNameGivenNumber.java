package newDynamic;

public class FindExcelColumnNameGivenNumber {
	void printString(int columnNumber)
    {
        // To store result (Excel column name)
        StringBuilder columnName = new StringBuilder();
 
        while (columnNumber > 0)
        {
            // Find remainder
            int rem = columnNumber % 26;
 
            // If remainder is 0, then a 
            // 'Z' must be there in output
            if (rem == 0)
            {
                columnName.append("Z");
                columnNumber = (columnNumber / 26) - 1;
            }
            else // If remainder is non-zero
            {
                columnName.append((char)((rem - 1) + 'A'));
                columnNumber = columnNumber / 26;
            }
        }
 
        // Reverse the string and print result
        System.out.println(columnName.reverse());
    }
	public static void main(String[] args) {
		FindExcelColumnNameGivenNumber obj = new FindExcelColumnNameGivenNumber();
		obj.printString(26);
		obj.printString(51);
        obj.printString(52);
        obj.printString(80);
        obj.printString(676);
        obj.printString(702);
        obj.printString(705);
	}
}
