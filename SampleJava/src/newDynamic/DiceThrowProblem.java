package newDynamic;

public class DiceThrowProblem {
	int getWays( int NumberOfFaces, int numberOfDice, int numbertoGet)
	{
		int[][] table = new int[numberOfDice+1][numbertoGet+1];
		for(int i=1;i<=NumberOfFaces && i<numbertoGet;i++)
		{
			table[1][i] = 1;
		}
		for(int i=2;i<=numberOfDice;i++)
		{
			for(int j=1;j<=numbertoGet;j++)
			{
				for(int k=1;k<=NumberOfFaces && k<j;k++)
				{
					table[i][j] += table[i-1][j-k];
				}
			}
		}
		return table[numberOfDice][numbertoGet];
	}
	public static void main(String[] args) {
		DiceThrowProblem obj = new DiceThrowProblem();
		System.out.println(obj.getWays(4, 2, 1));
	    System.out.println(obj.getWays(2, 2, 3));
	    System.out.println(obj.getWays(6, 3, 8));
	    System.out.println(obj.getWays(4, 2, 5));
	    System.out.println(obj.getWays(4, 3, 5));
	}
}
