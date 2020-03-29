package PhaseTwo;

import java.util.Arrays;

public class ABooleanMatrixQuestion_p2 {
	public boolean[][] convertRowColumn(boolean[][] arr)
	{
		int rows = arr.length;
		int cols=arr[0].length;
		boolean firstRow=false;
		boolean firstCol=false;
		
		for(int i=0;i<rows;i++)
			for(int j=0;j<cols;j++)
			{
				if(arr[i][j])
				{
					if(i==0)
					{
						firstRow=true;
					}
					if(j==0)
					{
						firstCol=true;
					}
					if(i!=0 && j!=0)
					{
						arr[0][j] = true;
						arr[i][0] = true;
					}
				}	
			}
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if(arr[0][j] || arr[i][0])
				{
					arr[i][j]=true;
				}
			}
		}
		if(firstCol)
		{
			for (int i = 0; i < rows; i++) {
				arr[i][0]=true;
			}
		}
		if(firstRow)
		{
			for (int i = 0; i < cols; i++) {
				arr[0][i]=true;
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		ABooleanMatrixQuestion_p2 obj = new ABooleanMatrixQuestion_p2();
		boolean mat[][] = {{true, false, false, true}, 
							{false, false, true, false}, 
							{false, false, false, false}}; 
		mat=obj.convertRowColumn(mat);
		for(int i=0;i<3;i++)
		{
			System.out.println(Arrays.toString(mat[i]));
		}
	}
}
