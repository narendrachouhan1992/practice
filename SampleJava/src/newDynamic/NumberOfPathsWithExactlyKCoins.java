package newDynamic;

public class NumberOfPathsWithExactlyKCoins {
	int numberOfPath(int[][] arr, int i, int j, int k)
	{
		if(i<0 || j<0 )
		 return 0;
		if(i==0 && j==0)
		{
			if(k == arr[0][0])
				return 1;
			return 0;
		}
		return (numberOfPath(arr, i-1, j, k-arr[i][j])+numberOfPath(arr, i, j-1, k-arr[i][j])); 
	}
	public static void main(String[] args) {
		NumberOfPathsWithExactlyKCoins obj = new NumberOfPathsWithExactlyKCoins();
		int mat[][] = { {1, 2, 3},
                {4, 6, 5},
                {3, 2, 1}};
                System.out.println(obj.numberOfPath(mat, 2, 2, 12));
                
	}
}
