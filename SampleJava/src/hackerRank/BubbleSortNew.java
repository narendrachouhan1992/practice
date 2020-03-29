package hackerRank;

public class BubbleSortNew {
	 public static void bubbleSort(int[] arr)
	    {
	        int length = arr.length;
	        int numberOfSwap = 0;
	        for(int i=0;i<length;i++)
	        {
	        	for(int j=0;j<i;j++)
	        	{
	        		if(arr[i]<arr[j])
	        		{
	        			int temp = arr[i];
	        			arr[i] = arr[j];
	        			arr[j] = temp;
	        			numberOfSwap++;
	        		}
	        	}
	        }
	        System.out.println("Array is sorted in "+numberOfSwap+" swaps.");
	        System.out.println("First Element: "+arr[0]);
	        System.out.println("Last Element: "+arr[length-1]);
	    }
}
