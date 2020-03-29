package newDynamic;

import java.util.Arrays;

public class KLargestorSmallestElementsInAnArray {
	void heapify(int arr[], int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
	void printKLargest(int[] arr, int k)
	{
		// using max heap
		if(k==0)
			return;
		int length = arr.length;
		if(k>=length)
		{
			System.out.println(Arrays.toString(arr));
			return;
		}
		for(int i=length/2-1; i>=0;i--)
		{
			heapify(arr, length, i);
		}
		System.out.print(arr[0] + ", ");
		arr[0] = Integer.MIN_VALUE;
		printKLargest(arr, k-1);
	}
	public static void main(String[] args) {
		KLargestorSmallestElementsInAnArray obj = new KLargestorSmallestElementsInAnArray();
		int[] arr = {1, 23, 12, 9, 30, 2, 50};
		obj.printKLargest(arr, 5);
	}
}
