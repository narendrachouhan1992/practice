package newDynamic;

public class LengthOfTheLongestConsecutivePathInCharacterMatrix 
{
	static int getLength(char[][] arr)
	{

		int size = arr.length;
		int[][] dp = new int[size][size];
		int[] move_x = {1,1,1,0,0,-1,-1,-1};
		int[] move_y = {1,0,-1,1,-1,1,-1,0};
		
		for(int i=0;i<size;i++)
		{	
			
			for(int j =0;j<size;j++)
			{
				dp[i][j]= 1;
			}
		}
		for(int i=0;i<size;i++)
		{	
			for(int j =0;j<size;j++)
			{
				for(int k =0;k<8;k++)
				{
					if(i+move_x[k]<size && i+move_x[k]>=0 && j+move_y[k]<size && j+move_y[k]>=0)
					{
						
						if(arr[i][j]+1==arr[i+move_x[k]][j+move_y[k]])
						{
							dp[i][j] = Integer.max(dp[i][j], dp[i+move_x[k]][j+move_y[k]]+1);
						}
					}
				}
			}
		}
		return 	dp[0][0];
	}
	public static void main(String[] args) {
		char[][] arr = { {'a','c','d'},
			            { 'h','b','a'},
			            { 'i','g','f'}};
		System.out.println(getLength(arr))
		
		;
	}
}
