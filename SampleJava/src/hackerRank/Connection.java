package hackerRank;
import java.util.List;
public class Connection {
	static boolean isValid(List<List<Integer>> matrix, int x, int y)
	{
		if(x>=0 && x<matrix.size() && y>= 0 && y< matrix.get(0).size() && matrix.get(x).get(y) == 1)
		{
			return true;
		}
		return false;
	}
	static int countConnections(List<List<Integer>> matrix) {
		int count = 0;
		int rows = matrix.size();
		int columns = matrix.get(0).size();
		int[] nextX = {1, 1 ,1, 0, -1, -1, -1, 0};
		int[] nextY = {-1, 0, 1, 1, 1, 0, -1, -1};
		for(int i=0;i<rows;i++)
		{
			for(int j = 0;j<columns; j++)
			{
				for(int k =0;k<8;k++)
				{
					if(matrix.get(i).get(j) == 1 && isValid(matrix, i+nextX[k], j+nextY[k]))
					{
						count ++;
					}
				}
			}
		}
		count = count/2;
		return count;
    }
     
}
