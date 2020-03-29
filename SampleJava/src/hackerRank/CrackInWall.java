package hackerRank;

import java.util.Scanner;

public class CrackInWall {
	
	int getSol(int[][] mat, int i, int j)
	{
		if(i == mat.length)
			return 1;
		
		if(j + 2 == mat[0].length-1)
		{
			mat[i][j+2] = 1;
			return getSol(mat, i+1, 0);
		}
		else if (j + 3 == mat[0].length-1)
		{
			mat[i][j+3] = 1;
			return getSol(mat, i+1, 0);
		}
		else if(i==0)
		{
			int sol = 0;
			if(j+2<mat[0].length)
			{
				mat[i][j+2] = 1;
				sol+= getSol(mat, i, j+2);
				mat[i][j+2] = 0; 
			}
			if(j+3<mat[0].length)
			{
				mat[i][j+3] = 1;
				sol+= getSol(mat, i, j+3);
				mat[i][j+3] = 0; 
			}
			return sol;
		}
		else
		{
			int sol = 0;
			if(j+2<mat[0].length && mat[i-1][j+2] != 1)
			{
				mat[i][j+2] = 1;
				sol+= getSol(mat, i, j+2);
				mat[i][j+2] = 0; 
			}
			if(j+3<mat[0].length && mat[i-1][j+3] != 1)
			{
				mat[i][j+3] = 1;
				sol+= getSol(mat, i, j+3);
				mat[i][j+3] = 0; 
			}
			return sol;
		}
	}
	int getNumberOfWays(int height, int width, int mod)
	{
		if(width<2)
			return 0;
		int[][] matrix = new int[height][width+1];
		for(int i=0;i<height;i++)
		{
			matrix[i][0] = 1;
		}
		int sol = getSol(matrix, 0, 0);
		
		
		return sol%1000;
	}
	public static void main(String[] args) {
		CrackInWall obj = new CrackInWall();
		Scanner sc = new Scanner(System.in);
		int width =sc.nextInt();
		int height = sc.nextInt();
		int mod = sc.nextInt();
		System.out.println(obj.getNumberOfWays(height, width, mod));
		sc.close();
	}
}
