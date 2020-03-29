package newDynamic;

public class FindASortedSubsequenceOfSize3InLinearTime {
	void printRes(int[] arr)
	{
		int length = arr.length;
		int max = length -1;
		int min = 0;
		int[] less = new int[length];
		int[] more = new int[length];
		less[0] = -1;
		more[length-1] = -1;
		for(int i=1;i<length;i++)
		{
			if(arr[i]<arr[min])
			{
				min = i;
				less[i] = -1;
			}
			else
			{
				less[i] = min;
			}
		}
		for(int i=length-2;i>=0;i--)
		{
			if(arr[i]>arr[max])
			{
				max = i;
				more[i] = -1;
			}
			else
			{
				more[i] = max;
			}
		}
		for(int i=0;i<length;i++)
		{
			if(less[i]!= -1 && more[i]!=-1)
			{
				System.out.println(arr[less[i]]+ " "+arr[i] +" "+ arr[more[i]]);
				return;
			}
		}
		System.out.println("no number sequence found");
	}
	public static void main(String[] args) {
		FindASortedSubsequenceOfSize3InLinearTime obj = new FindASortedSubsequenceOfSize3InLinearTime();
		int[] arr = {12, 11, 10, 5, 6, 2, 30};
		obj.printRes(arr);
	}
}
