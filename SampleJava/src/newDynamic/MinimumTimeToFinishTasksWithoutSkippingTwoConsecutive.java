package newDynamic;

public class MinimumTimeToFinishTasksWithoutSkippingTwoConsecutive {
	int minTime(int[] arr)
	{
		int size = arr.length;
		int inc = arr[0];
		int exc = 0;
		
		
		for(int i = 1;i< size;i++)
		{
			int new_inc = arr[i] + Integer.min(inc, exc);
			int new_exc = inc;
			
			inc = new_inc;
			exc = new_exc;
		}
		return Integer.min(inc, exc);
	}
	public static void main(String[] args)
    {
		MinimumTimeToFinishTasksWithoutSkippingTwoConsecutive obj = new MinimumTimeToFinishTasksWithoutSkippingTwoConsecutive();
        int arr1[] = {10, 5, 2, 7, 10};
        int n1 = arr1.length;
        System.out.println(obj.minTime(arr1));
 
        int arr2[] = {10, 5, 7, 10};
        int n2 = arr2.length;
        System.out.println(obj.minTime(arr2));
 
        int arr3[] = {10, 5, 2, 4, 8, 6, 7, 10};
        int n3 = arr3.length;
        System.out.println(obj.minTime(arr3));
 
    }
}
