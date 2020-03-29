package newDynamic;

public class SearchAnElementInASortedAndPivotedArray {
	int findElement(int[] arr, int num)
	{
		int peviot = findPiviot(arr, 0, arr.length-1);
		return peviot;
	}
	int findPiviot(int[] arr, int high, int low)
	{
		 // base cases
	       if (high < low)  
	            return -1;
	       if (high == low) 
	            return low;
	        
	       /* low + (high - low)/2; */
	       int mid = (low + high)/2;   
	       if (mid < high && arr[mid] > arr[mid + 1])
	           return mid;
	       if (mid > low && arr[mid] < arr[mid - 1])
	           return (mid-1);
	       if (arr[low] >= arr[mid])
	           return findPiviot(arr, low, mid-1);
	       return findPiviot(arr, mid + 1, high);
	}
	
	public static void main(String[] args) {
		SearchAnElementInASortedAndPivotedArray obj = new SearchAnElementInASortedAndPivotedArray();
		int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		System.out.println(obj.findElement(arr, 3));
	}
}
