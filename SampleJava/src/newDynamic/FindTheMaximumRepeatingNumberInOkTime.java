package newDynamic;

public class FindTheMaximumRepeatingNumberInOkTime {
	int getMaxrepeat(int[] arr, int k)
	{
		int length = arr.length;
		for(int i =0;i<length;i++)
		{
			arr[arr[i]%k] +=k;
		}
		int res = -1;int max = 0;
		for(int i=0;i<length;i++)
		{
			if(arr[i]>max)
			{
				max = arr[i];
				res = i;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		FindTheMaximumRepeatingNumberInOkTime obj = new FindTheMaximumRepeatingNumberInOkTime();
		int arr[] = {2, 3, 3, 5, 3, 4, 1, 7};
		System.out.println(obj.getMaxrepeat(arr, 8));
	}
}
