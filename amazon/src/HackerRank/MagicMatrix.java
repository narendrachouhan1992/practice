package HackerRank;

public class MagicMatrix {
	// Complete the formingMagicSquare function below.
	static int formingMagicSquare(int[][] s) 
	{
		int[][][] pre = new int[8][3][3];
		
		int[][] msq1 = {{8,1,6},
				{3,5,7},
				{4,9,2}};
		int[][] msq2 = {{4,3,8	},
						{9,5,1},
						{2,7,6}};
		int[][] msq3 = {{2,9,4},
						{7,5,3},
						{6,1,8}};
		int[][] msq4 = {{6,7,2},
						{1,5,9},
						{6,3,4}};
		int[][] msq5 = {{6,1,8},
						{7,5,3},
						{2,9,4}};
		int[][] msq6 = {{8,3,4},
						{1,5,9},
						{6,7,2}};
		int[][] msq7 = {{4,9,2},
						{3,5,7},
						{8,1,6}};
		int[][] msq8 = {{2,7,6},
						{9,5,1},
						{4,3,8}};
		pre[0] = msq1;
		pre[1] = msq2;
		pre[2] = msq3;
		pre[3] = msq4;
		pre[4] = msq5;
		pre[5] = msq6;
		pre[6] = msq7;
		pre[7] = msq8;
		
		int min = Integer.MAX_VALUE;
		for(int i=0;i<8;i++)
		{
			int diff = 0;
			for(int j=0;j<3;j++)
				for(int k=0;k<3;k++)
				{
					diff += Math.abs(s[j][k]-pre[i][j][k]);
				}
			min = Integer.min(min, diff);
		}
		return min;
	}
	public static void main(String[] args) {
		int[][] arr = {{7, 6 ,5},
		{7, 2, 8},
		{5 ,3 ,4}};
		System.out.println(formingMagicSquare(arr));
	}
	
}
