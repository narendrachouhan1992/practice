package GraphAlgos;


public class LargestAreaWithOne {
	static class Count
	{
		int count =0;
	}
	boolean isSafe(int x, int y, boolean[][] mat)
	{
		if(x<0 || y<0 || x>= mat.length || y >= mat[0].length || !mat[x][y])
			return false;
		return true;
	}
	void DFS(int x, int y, boolean[][] mat, boolean[][] visited, Count count)
	{
		int rowNbr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
	    int colNbr[] = {-1, 0, 1, -1, 1, -1, 0, 1};
	    for(int i=0;i<8;i++)
	    {
	    	if(isSafe(x+ rowNbr[i], y+ colNbr[i], mat) && !visited[x+ rowNbr[i]][ y+ colNbr[i]])
	    	{
	    		visited[x+ rowNbr[i]][ y+ colNbr[i]] = true;
	    		count.count++;
	    		DFS(x+ rowNbr[i], y+ colNbr[i], mat, visited, count);
	    	}
	    }
	    
	}
	int getMargestRegion(boolean[][] mat)
	{
		boolean[][] visited = new boolean[mat.length][mat[0].length];
		Count count = new Count();
		int res = 0;
		for(int i=0;i<mat.length;i++)
		{
			for(int j=0;j<mat[0].length;j++)
			{
				if(mat[i][j] && !visited[i][j])
				{
					visited[i][j] = true;
					count.count = 1;
					DFS(i, j, mat, visited, count);
					res = Integer.max(res, count.count);
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		LargestAreaWithOne obj = new LargestAreaWithOne();
		boolean[][] mat = { {false, false, true, true, false},
				{true, false, false, true, false},
				{false, true, false, false, false},
				{false, false, false, false, true}};
		System.out.println(obj.getMargestRegion(mat));
	}
}
