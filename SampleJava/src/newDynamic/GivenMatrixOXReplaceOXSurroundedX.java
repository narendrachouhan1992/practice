package newDynamic;

public class GivenMatrixOXReplaceOXSurroundedX {
	char[][] screen = {{'X', 'O', 'X', 'O', 'X', 'X'},
            {'X', 'O', 'X', 'X', 'O', 'X'},
            {'X', 'X', 'X', 'O', 'X', 'X'},
            {'O', 'X', 'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'O', 'X', 'O'},
            {'O', 'O', 'X', 'O', 'O', 'O'},
           };
	void fillFlood(int i, int j, char prevC, char newC)
	{
		if(i<0 || j<0 || i>= screen.length || j>= screen[0].length)
			return;
		if(screen[i][j] == prevC)
		{
			screen[i][j] = newC;
			fillFlood( i+1, j, prevC, newC);
			fillFlood( i, j+1, prevC, newC);
			fillFlood( i, j-1, prevC, newC);
			fillFlood( i-1, j, prevC, newC);
		}	
	}
	void ReplaceAll0WithXW()
	{
		for(int i=0;i<screen.length;i++)
			for(int j=0; j< screen[0].length;j++)
			{
				if(screen[i][j] == '0')
				{
					screen[i][j] = '-';
				}
			}
		for(int i=0;i<screen.length;i++)
		{
			fillFlood(i, 0, '-', '0');
			fillFlood(i, screen[0].length-1, '-', '0');
		}
		for(int i=0;i<screen[0].length;i++)
		{
			fillFlood(0, i, '-', '0');
			fillFlood(i, screen.length-1, '-', '0');
		}
		for(int i=0;i<screen.length;i++)
			for(int j=0; j< screen[0].length;j++)
			{
				if(screen[i][j] == '0')
				{
					screen[i][j] = 'X';
				}
			}
	}
	void printMat()
	{
		for (char[] cs : screen) {
			for (char c : cs) {
				System.out.print(c+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		GivenMatrixOXReplaceOXSurroundedX obj = new GivenMatrixOXReplaceOXSurroundedX();
		obj.printMat();
		System.out.println();
		obj.ReplaceAll0WithXW();
		obj.printMat();
	}
}
