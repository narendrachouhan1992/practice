package newDynamic;

public class FindLengthLargestRegionBooleanMatrix {
	boolean isSafe(int i, int j, int ROW, int COL)
	{
		return (i >=0 && i<ROW && j>=0 && j<COL);
	}
	int  DFS(boolean[][] matrix, boolean[][] visited, int count, int i, int j)
	{
		 int[] rowNbr = {-1, -1, -1, 0, 0, 1, 1, 1};
		 int[] colNbr = {-1, 0, 1, -1, 1, -1, 0, 1};
		 visited[i][j] = true;
		 for(int x=0;x<8;x++)
		 {
			 if(isSafe(i+rowNbr[x], j+ colNbr[x], matrix.length, matrix[0].length) && matrix[i+rowNbr[x]][ j+ colNbr[x]] &&  !visited[i+rowNbr[x]][j+ colNbr[x]])
			 {
				 count= DFS(matrix, visited, count+1, i+rowNbr[x], j+ colNbr[x]);
			 }
		 }
		 return count;
	}
	int findLargestIslsland(boolean[][] matrix)
	{
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		int res = 0;
		for(int i =0;i<matrix.length;i++)
			for(int j=0;j<matrix[0].length;j++)
			{
				if(matrix[i][j] && !visited[i][j])
				{
					res = Integer.max(res, DFS(matrix, visited, 1, i, j));
				}
			}
		return res;
	}
	public static void main(String[] args) {
		FindLengthLargestRegionBooleanMatrix obj = new FindLengthLargestRegionBooleanMatrix();
		boolean[][] matrix =  { {false, false, true, true, false},
                {true, false, true, true, false},
                {false, true, false, false, false},
                {false, false, false, false, true}};
		System.out.println(obj.findLargestIslsland(matrix));
	}
}
