package newDynamic;

import java.util.Arrays;

public class FindFourNumbersWithSumEqualToGivenSum {
	void printQuadrupletsWithSumN(int[] arr, int sum)
	{
		Arrays.sort(arr);
		int size = arr.length;
		for(int i=0;i<size-3;i++)
		{
			for(int j=i+1;j<size-2;j++)
			{
				int l = j+1;
				int r= size-1;
				while(l<r)
				{
					if(arr[i]+ arr[j]+ arr[l]+ arr[r] == sum)
					{
						System.out.println(arr[i] +", "+ arr[j]+ ", "+arr[l]+ ", "+arr[r] );
						l++;
						r--;
					}
					else if((arr[i]+ arr[j]+ arr[l]+ arr[r] < sum))
					{
						l++;
					}
					else {
						r--;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		FindFourNumbersWithSumEqualToGivenSum obj = new FindFourNumbersWithSumEqualToGivenSum();
        int[] A = {1, 4, 45, 6, 10, 12};
        int X = 21;
        obj.printQuadrupletsWithSumN(A, X);
	}
}
