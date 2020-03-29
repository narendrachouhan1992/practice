package newDynamic;

public class BackttrackingSet2RatInAMaze {
	void solveMaze(boolean[][] maze)
	{
		boolean[][] sol = new boolean[maze.length][maze[0].length];
		if(!solveMazeUntil(maze, 0, 0 , sol))
		{
			System.out.println("Solution doesn't exist");
			return;
		}
		for(int i =0;i<sol.length;i++)
		{
			for(int j=0;j<maze[0].length;j++)
			{
				System.out.print(sol[i][j]? "1 ": "0 ");
			}
			System.out.println();
		}
	}
	boolean isSafe(int x, int y, boolean[][] maze)
	{
		return (x<maze.length && y<maze[0].length && maze[x][y]);
	}
	boolean solveMazeUntil(boolean[][] maze, int x, int y, boolean[][] sol)
	{
		if(x== maze.length-1 && y == maze[0].length-1)
		{
			sol[x][y] = true;
			return true;
		}
		if(isSafe(x, y, maze))
		{
			sol[x][y] = true;
			if(solveMazeUntil(maze, x+1, y, sol) || solveMazeUntil(maze, x, y+1, sol))
			{
				return true;
			}
			sol[x][y] = false;
		}
		return false;
	}
	public static void main(String[] args) {
		BackttrackingSet2RatInAMaze obj = new BackttrackingSet2RatInAMaze();
		boolean maze[][] = {{true, false, false, false},
	            {true, true, false, true},
	            {false, true, false, false},
	            {true, true, true, true}
	        };
		obj.solveMaze(maze);
	}
}
