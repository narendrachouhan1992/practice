package newDynamic;

public class GivenMatrixOXFindLargestSubsquareSurroundedX {
	int getMax(char[][] mat)
	{
		int rows = mat.length;
		int cols = mat[0].length;
		int[][] hor = new int[rows][cols];
		int[][] ver = new int[rows][cols];
		int max = 0;
		for(int i=0;i<rows;i++)
			for(int j=0;j<cols;j++)
			{
				if(mat[i][j] == 'X')
				{
					hor[i][j] = j==0? 1: hor[i][j-1]+1;
					ver[i][j] = i==0? 1: ver[i-1][j]+1;
				}
			}
		for(int i=rows-1;i>=0;i--)
		{
			for(int j=cols-1;j>=0;j--)
			{
				int small = Integer.min(hor[i][j], ver[i][j]);
				while(small>max)
				{
					if(hor[i-small+1][j]>=small &&
							ver[i][j-small+1]>= small)
					{
						max = small;
					}
					small--;
				}
			}
		}
		return max;
	}
	public static void main(String[] args) {
		GivenMatrixOXFindLargestSubsquareSurroundedX obj = new GivenMatrixOXFindLargestSubsquareSurroundedX();
		char[][] mat = {{'X', 'O', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'O', 'O', 'X'},
                {'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'O', 'X', 'O'},
                {'O', 'O', 'X', 'O', 'O', 'O'},
               };
		System.out.println(obj.getMax(mat));
	}
}	
