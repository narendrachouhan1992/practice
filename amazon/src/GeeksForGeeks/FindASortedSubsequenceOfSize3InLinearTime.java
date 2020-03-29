package GeeksForGeeks;

public class FindASortedSubsequenceOfSize3InLinearTime {
	static void printSequence(int[] arr)
	{
		if(arr==null || arr.length<3)
			System.out.println("not possible");
		
		int n = arr.length;
		int[] less = new int[n];
		int min = 0;
		for(int i=1;i<n;i++)
		{
			if(arr[i]<arr[min])
			{
				min = i;
				less[i] =-1;
			}
			else
				less[i] = min;
		}
		int max = n-1;
		int[] more = new int[n];
		for(int i=n-1;i>=0;i--)
		{
			if(arr[i]>arr[max])
			{
				max = i;
				more[i] = -1;
			}
			else
				more[i] = max;
		}
		for(int i=1;i<n-1;i++)
		{
			if(less[i]!=-1 && more[i]!=-1)
			{
				System.out.println(arr[less[i]]+", "+arr[i]+", "+arr[more[i]]);
			}
		}
	}
	public static void main(String[] args) {
		int arr[] = {12, 11, 10, 5, 6, 2, 30}; 
		printSequence(arr);
	}
	
	
	
}
