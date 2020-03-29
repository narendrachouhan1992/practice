package newDynamic;

public class MaximizeNumber0sFlippingSubarray {
	int getMax(int[] arr)
	{
		int zero_count = 0;
		int curr_max = 0;
		int max = 0;
		for(int i =0;i<arr.length;i++)
		{
			if(arr[i] == 0)
				zero_count++;
			
			arr[i] = arr[i]==0?-1:1;
			curr_max = Integer.max(curr_max+arr[i], arr[i]);
			max = Integer.max(curr_max, max);
		}
		max = Integer.max(0, max);
		return zero_count+max;
	}
	public static void main(String[] args) {
		MaximizeNumber0sFlippingSubarray obj = new MaximizeNumber0sFlippingSubarray();
		int arr[] = {0, 1, 0, 0, 1, 1, 0};
		System.out.println(obj.getMax(arr));
	}
}
