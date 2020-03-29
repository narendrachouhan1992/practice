package newDynamic;

public class MobileNumericKeypadProblem {
	boolean isValid(int i, int j)
	{
		if(i<0 || j<0 || i>3 || j>2 || (i==3 && j!= 1))
			return false;
		return true;
	}
	int getNumberOfWays(int i, int j, int n)
	{
		int res = 0;
		int row[] = {0, 0, -1, 0, 1};
		int col[] = {0, -1, 0, 1, 0};
		if(n==0)
			return 0;
		if(n==1)
		{
			return 1;
		}
		for(int k=0;k<5;k++)
		{
			if(isValid(i+row[k], j+col[k]))
			{
				res += getNumberOfWays(i+row[k], j+col[k], n-1);
			}
		}
		
		
		return res;
	}
	int getAllWays(int n)
	{
		if(n<=0)
			return 0;
		if(n==1)
			return 10;
		int i=0;
		int j=0;
		int totalCount = 0;
		 for (i=0; i<4; i++)  // Loop on keypad row
		    {
		        for (j=0; j<3; j++)   // Loop on keypad column
		        {
		            // Process for 0 to 9 digits
		            if (isValid(i, j))
		            {
		                totalCount += getNumberOfWays(i, j, n);
		            }
		        }
		    }
		    return totalCount;
	}
	public static void main(String[] args) {
		MobileNumericKeypadProblem obj = new MobileNumericKeypadProblem();
		int i = 1;
		while(i!=10)
		{
			System.out.println("for number "+i+" value is "+ obj.getAllWays(i));
			i++;
		}
	}
}
