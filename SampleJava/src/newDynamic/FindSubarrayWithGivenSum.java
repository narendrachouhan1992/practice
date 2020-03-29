package newDynamic;

public class FindSubarrayWithGivenSum {
	void prSubArray(int[] arr, int sum)
	{
		
		int curr_sum = arr[0];
		int start = 0;
		int end = 0;
		while(end < arr.length && start<=end)
		{
			if(curr_sum<sum)
			{
				curr_sum+= arr[++end];
				
			}
			else if(curr_sum == sum)
			{
				System.out.println("yes");
				for(int i =start;i<=end;i++)
				{
					System.out.print(arr[i] + " ");
				}
					break;
			}
			else
			{
				curr_sum -= arr[start];
				start++;
			}
		}
	}
	public static void main(String[] args) {
		FindSubarrayWithGivenSum obj = new FindSubarrayWithGivenSum();
		int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
		obj.prSubArray(arr, 23);
	}
}
