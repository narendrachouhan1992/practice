package newDynamic;

public class MedianOfTwoSortedArrays {
	int getMedian(int[] arr1, int[] arr2, int s1, int s2, int e1, int e2)
	{
		int n = arr1.length;
		if(n==0)
			return -1;
		if(n==1)
			return ((arr1[0]+ arr2[0])/2);
		if(n==2)
		{
			return (Integer.max(arr1[0], arr2[0])+ Integer.min(arr1[1], arr2[1]))/2;
		}
		int m1 = median(arr1, s1, e1);
		int m2 = median(arr1, s2, e2);
		if(m1 == m2)
			return m1;
		if(m1<m2)
		{
			int length = e1-s1; 
			if(length%2 == 0)
			{
				getMedian(arr1, arr2, s1+ length/2-1, s2, e1, e2-length/2+1);
			}
			return getMedian(arr1, arr2, s1+length/2, s2, e1, e2-length/2);
		}
		else
		{
			int length = e1-s1; 
			if(length%2 == 0)
			{
				getMedian(arr1, arr2, s1, s1+length/2-1, e1-length/2+1, e2);
			}
			return getMedian(arr1, arr2, s1, s1+length/2, e1-length/2, e2);
		}
	}
	int median(int[] arr, int start, int end)
	{
		int mid = (start+end)/2;
		if((end-start)%2 == 0)
		{
			return (arr[mid] + arr[mid -1])/2;
		}
		return arr[mid];
	}
	public static void main(String[] args) {
		MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
		 int ar1[] = {1, 2, 3, 6};
		 int ar2[] = {4, 6, 8, 10};
		 System.out.println(obj.getMedian(ar1, ar2, 0, 0, 3, 3));
	}
}
