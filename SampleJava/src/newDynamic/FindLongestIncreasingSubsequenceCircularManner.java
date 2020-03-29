package newDynamic;

public class FindLongestIncreasingSubsequenceCircularManner {
	int getLISCircular(int[] arr)
	{
		int[] arr1 = new int[arr.length*2];
		int length = arr.length;
		int[] lis = new int[length*2];
		for(int i=0;i<length*2;i++)
		 {
			 lis[i]=1;
			
		 }
		 for(int i=1;i<length*2;i++)
		 {
			 for(int j=0;j<i;j++)
			 {
				 if(arr[i%length]> arr[j%length] && lis[j]+1 >lis[i])
				 {
					 lis[i] = lis[j]+1;
				 }
			 }
		 }
		return lis[length*2-1];
	}
	public static void main(String[] args) {
		FindLongestIncreasingSubsequenceCircularManner obj = new FindLongestIncreasingSubsequenceCircularManner();
		 int arr[] = { 1, 4, 6, 2, 3 };
		 System.out.println(obj.getLISCircular(arr));
	}
}
