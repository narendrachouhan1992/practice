package amazone;

public class MaximumSumIarriAmongRotationsGivenArray {
	int getMaxValueRotation(int[] arr)
	{
		int cum_sum = 0;
		int length = arr.length;
		int curr_val= 0;
		for(int i=0;i<length;i++)
		{
			cum_sum+= arr[i];
			curr_val += i * arr[i];
		}
		int maxSum = curr_val;
		for(int i=1;i<length;i++)
		{
			int sum_next = curr_val - (cum_sum -arr[i-1]) + (length-1)* arr[i-1];
			curr_val = sum_next;
			maxSum = Integer.max(sum_next, maxSum);
		}
		return maxSum;
	}
	public static void main(String[] args) {
		MaximumSumIarriAmongRotationsGivenArray obj = new MaximumSumIarriAmongRotationsGivenArray();
		int[] arr = {8, 3, 1, 2};
		System.out.println(obj.getMaxValueRotation(arr));
	}
}
