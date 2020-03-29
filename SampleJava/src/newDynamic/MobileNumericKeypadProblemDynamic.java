package newDynamic;

public class MobileNumericKeypadProblemDynamic {
	int[][] numberPad = {{1,2,3,},
						{4,5,6},
						{7,8,9},
						{0,0,0}};
	boolean isValid(int i, int j)
	{
		if(i<0 || j<0 || i>3 || j>2 || (i==3 && j!= 1))
			return false;
		return true;
	}
	
	int getNumberOfWays(int n)
	{
		int[][] count = new int[10][n+1];
		int row[] = {0, 0, -1, 0, 1};
		int col[] = {0, -1, 0, 1, 0};
		for(int i=0;i<10;i++)
		{
			count[i][0] = 0;
			count[i][1] = 1;
		}
		for(int k =2;k<=n;k++)
		{
			for (int i=0; i<4; i++)  // Loop on keypad row
	        {
	            for (int j=0; j<3; j++)
	            {
	            	if(isValid(i, j))
	            	{
	            		for(int move = 0;move<5;move++)
	            		{
	            			if(isValid(i+row[move], j+col[move]))
	            			{
	            				count[numberPad[i][j]][k] += count[numberPad[i+ row[move]][j+col[move]]][k-1];
	            			}
	            		}
	            	}
	            }
	        }
		}
		int totalCount = 0;
	    for (int i=0; i<=9; i++)
	        totalCount += count[i][n];
	    return totalCount;
	}
	public static void main(String[] args) {
		MobileNumericKeypadProblemDynamic obj = new MobileNumericKeypadProblemDynamic();
		int i = 1;
		while(i!=10)
		{
			System.out.println("for number "+i+" value is "+ obj.getNumberOfWays(i));
			i++;
		}
	}
}
