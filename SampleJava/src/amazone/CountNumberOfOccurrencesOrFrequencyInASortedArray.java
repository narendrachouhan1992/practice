package amazone;

public class CountNumberOfOccurrencesOrFrequencyInASortedArray {
	int getFirst(int[] arr, int start, int end, int num)
	{
		if(start<=end)
		{
			int mid = (start+end)/2;
			if(( mid == 0 || num > arr[mid-1]) && arr[mid]==num)
			{
				return mid;
			}
			else if(num>arr[mid])
			{
				return getFirst(arr, mid+1, end, num);
			} 
			else 
			{
				return getFirst(arr, start, mid-1, num);
			}
		}
		return -1;
	}
	int getlast(int[] arr, int start, int end, int num)
	{
		if(start<=end)
		{
			int mid = (start+end)/2;
			if(( mid == arr.length-1 || num < arr[mid+1]) && arr[mid]==num)
			{
				return mid;
			}
			else if(num<arr[mid])
			{
				return getlast(arr, start, mid-1, num);
			} 
			else 
			{
				return getlast(arr, mid+1, end, num);
			}
		}
		return -1;
	}
	int getFreq(int[] arr, int num)
	{
		int length = arr.length;
		int first = getFirst(arr, 0, length -1, num );
		int last = getlast(arr, 0, length-1, num);
		return (last-first+1);
	}
	public static void main(String[] args) {
		int arr[] = {1, 2, 2, 3, 3, 3, 3};
		CountNumberOfOccurrencesOrFrequencyInASortedArray obj = new CountNumberOfOccurrencesOrFrequencyInASortedArray();
		System.out.println(obj.getFreq(arr, 3));
	}
}
