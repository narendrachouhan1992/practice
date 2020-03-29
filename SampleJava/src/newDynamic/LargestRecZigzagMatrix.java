package newDynamic;

public class LargestRecZigzagMatrix {
	int getLength(int[][] arr, int i, int j, int n)
	{
		if(i==n-1)
			return arr[i][j];
		int res = 0;
		for(int k=0;k<n;k++)
		{
			if(k!=j)
			{
				res = Integer.max(res, getLength(arr, i+1, k, n) );
			}
		}
		return (res+arr[i][j]);
	}
	int getTotalMaxLength(int[][] arr)
	{
		int res = 0;
		int n = arr.length;
		for(int j=0;j<n;j++)
		{
			res = Integer.max(res, getLength(arr, 0, j, n));
		}
		return res;
	}
	public static void main(String[] args) {
		int[][] arr = { {4, 2, 1},
			            {3, 9, 6},
			            {11, 3, 15}};
		LargestRecZigzagMatrix obj = new LargestRecZigzagMatrix();
		System.out.println(obj.getTotalMaxLength(arr)
				);
	}
}
