package hackerRank;

import java.io.*;
import java.util.*;
import java.text.*;

public class GetBiggestRegion {
	static int ROW;
	static int COL;
	public static boolean isSafe(int[][] M, int row, int col, boolean[][] visited)
	{
	    // row number is in range, column number is in
	    // range and value is 1 and not yet visited
	    return (row >= 0) && (row < ROW) &&
	           (col >= 0) && (col < COL) &&
	           (M[row][col]==1 && !visited[row][col]);
	}
    public static int DFS(int M[][], int row, int col, boolean visited[][], int count)
    {
        // These arrays are used to get row and column
        // numbers of 8 neighbours of a given cell
        int[] rowNbr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colNbr = {-1, 0, 1, -1, 1, -1, 0, 1};
     
        // Mark this cell as visited
        visited[row][col] = true;
     
        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k)
        {
            if (isSafe(M, row + rowNbr[k], col + colNbr[k],
                                                  visited))
            {
                // increment region length by one
                count = DFS(M, row + rowNbr[k], col + colNbr[k],
                                        visited, count+1);
            }
        }
        return count;
    }
    public static int getBiggestRegion(int M[][])
    {
        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
    	ROW = M.length;
    	COL = M[0].length;
        boolean[][] visited = new boolean[ROW][COL];
        int result  = Integer.MIN_VALUE;
        for (int i = 0; i < ROW; ++i)
        {
            for (int j = 0; j < COL; ++j)
            {
                // If a cell with value 1 is not
                if (M[i][j]==1 && !visited[i][j])
                {
                    // visited yet, then new region found
                    int count = 1 ;
                    count = DFS(M, i, j, visited , count);
     
                    // maximum region
                    result = Integer.max(result , count);
                }
             }
        }
        return result ;
    }
    
    public static void main(String[] args) {
       int grid[][] = {{1, 1, 0, 0},
        				{0, 1, 1, 0},
        				{0, 0, 1, 0},
        				{1, 0, 0, 0}};
        
        System.out.println(getBiggestRegion(grid));
    }
}
