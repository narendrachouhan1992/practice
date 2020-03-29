package newDynamic;

public class BacktrackingSet1TheKnightsTourProblem {
	int SIZE_OF_BOARD = 9;
	int[][] chess= new int[SIZE_OF_BOARD][SIZE_OF_BOARD];
	int[] move_x = {2, 1, -1, -2, -2, -1, 1, 2};
	int[] move_y = {1, 2, 2, 1, -1, -2, -2, -1};
	void printSolution(int sol[][]) {
        for (int x = 0; x < SIZE_OF_BOARD; x++) {
            for (int y = 0; y < SIZE_OF_BOARD; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }
	boolean isSafe(int i, int j)
	{
		if(i<0 || j<0 || i>=SIZE_OF_BOARD || j>=SIZE_OF_BOARD || chess[i][j] != -1)
			return false;
		return true;
	}
	boolean solveKTUtil(int i,int j,int move)
	{
		if(move == SIZE_OF_BOARD*SIZE_OF_BOARD)
			return true;
		
		for(int k=0;k<8;k++)
		{
			if(isSafe(i+ move_x[k],j+ move_y[k]))
			{
				chess[i + move_x[k]][j+ move_y[k]] = move;
				if(solveKTUtil(i + move_x[k], j+ move_y[k], move+1))
				{
					return true;
				}
				else
				{
					chess[i + move_x[k]][j+ move_y[k]] = -1;
				}
			}
		}
		return false;
	}
	void solveProb()
	{
		for(int i=0;i<SIZE_OF_BOARD;i++)
			for(int j=0;j<SIZE_OF_BOARD;j++)
			{
				chess[i][j] = -1;
			}
		chess[0][0] = 0;
		if (!solveKTUtil(0, 0, 1)) {
            System.out.println("Solution does not exist");
        } else
            printSolution(chess);
	}
	public static void main(String[] args) {
		BacktrackingSet1TheKnightsTourProblem obj = new BacktrackingSet1TheKnightsTourProblem();
		obj.solveProb();
	}
}
