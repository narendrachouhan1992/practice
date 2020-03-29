package newDynamic;

public class MaximumProductSubarray {
	int getMax(int[] arr)
	{
		int max_so_far = 1;
		int min_ending_here = 1;
		int max_ending_here = 1;
		for(int i =0;i<arr.length;i++)
		{
			if(arr[i]>0)
			{
				max_ending_here = max_ending_here*arr[i];
				min_ending_here = Integer.min(1, min_ending_here*arr[i]);
			}
			if(arr[i] == 0)
			{
				max_ending_here = 1;
				min_ending_here = 1;
			}
			else
			{
				int temp = max_ending_here;
				max_ending_here = Integer.max(1, min_ending_here*arr[i]);
				min_ending_here = temp*arr[i];
			}
			if(max_so_far<max_ending_here)
				max_so_far = max_ending_here;
		}
		return max_so_far;
	}
	public static void main(String[] args) {
		MaximumProductSubarray obj = new MaximumProductSubarray();
		int arr[] = {1, -2, -3, 0, 7, -8, -2};
		System.out.println(obj.getMax(arr));
	}
}
