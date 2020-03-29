package GeeksForGeeks;

public class RemoveMinimumElementsEitherSide2minMax {
	static int getMin(int[] arr)
	{
		
		int max_start = -1;
		int max_end = 0;
		for(int start=0;start<arr.length;start++)
		{
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for(int end = start;end<arr.length;end++)
			{
				if(min>arr[end]) min=arr[end];
				if(max<arr[end]) max=arr[end];
				if(min*2<=max)
				{
					break;
				}
				if(end-start>max_end-max_start || max_start==-1)
				{
					max_start = start;
					max_end=end;
				}
			}
		}
		if(max_start==-1)
			return -1;
		
		return (arr.length-(max_end-max_start+1));
	}
	public static void main(String[] args) {
		 int arr[] = {4, 5, 100, 9, 10, 11, 12, 15, 200}; 
		 System.out.println(getMin(arr));
	}
}
