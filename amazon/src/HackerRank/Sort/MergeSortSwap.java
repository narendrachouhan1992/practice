package HackerRank.Sort;

import java.util.Arrays;

public class MergeSortSwap {
	static int res = 0;

	static long countInversions11(int[] arr) {
		res = 0;
		sort(arr, 0, arr.length - 1);

		return res;
	}

	private static void sort(int arr[], int l, int r) {
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	private static void merge(int arr[], int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
				res++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	static long countInversions1(int[] arr) {
		  long inversionsCount = 0;

		   int [] lowerArray = new int [arr.length]; 
		   int [] higherArray = new int [arr.length]; //frm mid+1 to high


		   inversionsCount = countAndSort (arr, 0, arr.length - 1, lowerArray, higherArray);
		   return inversionsCount;
		}

		static long countAndSort(int [] arr, int low, int high, int [] lowerArray, int [] higherArray)
		{
		    long totalCount = 0;
		    long count = 0;
		    if (low < high)
		    {
		        int mid = low + (high-low) /2;

		        long lowerCount = countAndSort (arr, low, mid, lowerArray, higherArray);
		        long higherCount = countAndSort (arr, mid+1, high, lowerArray, higherArray);
		        totalCount += lowerCount + higherCount + countAndSortMerge (arr, low, mid, high, lowerArray, higherArray);
		    } 

		    return totalCount;
		}

		static long countAndSortMerge(int [] arr, int low, int mid, int high, int [] lowerArray, int [] higherArray)
		{
		    long countInversions = 0;

		    for (int i=0; i< (mid-low+1);i++)
		    {
		        lowerArray[i] = arr [low+i];
		    }

		    for (int i=0; i< (high-mid);i++)
		    {
		        higherArray[i] = arr [mid+1+i];
		    }

		    int lowIndex = 0;
		    int highIndex = 0;
		    int arrIndex = low;

		    while (lowIndex < (mid-low+1) && highIndex < (high-mid))
		    {
		        if (lowerArray[lowIndex] <= higherArray [highIndex])
		        {
		            arr[arrIndex] = lowerArray[lowIndex];

		            ++lowIndex;
		        }
		        else
		        {
		            arr[arrIndex] = higherArray[highIndex];

		            ++highIndex;
		            countInversions += (mid-low+1 - lowIndex);
		        }

		        ++arrIndex;
		    }


		    while (lowIndex < (mid-low+1))
		    {
		        arr[arrIndex] = lowerArray[lowIndex];

		        ++lowIndex;
		        ++arrIndex;
		    }

		    while (highIndex < (high-mid))
		    {
		        arr[arrIndex] = higherArray[highIndex];

		        ++highIndex;
		        ++arrIndex;
		    }

		    System.out.printf("CountandsortMerge inversions - %d", countInversions);
		    return countInversions;

		}
		
		
		
		
	    private static long countInversions(int[] arr) {
	        int[] aux = arr.clone();
	        return countInversions(arr, 0, arr.length - 1, aux);
	    }

	    private static long countInversions(int[] arr, int lo, int hi, int[] aux) {
	        if (lo >= hi) return 0;

	        int mid = lo + (hi - lo) / 2;

	        long count = 0;
	        count += countInversions(aux, lo, mid, arr);
	        count += countInversions(aux, mid + 1, hi, arr);
	        count += merge(arr, lo, mid, hi, aux);

	        return count;
	    }

	    private static long merge(int[] arr, int lo, int mid, int hi, int[] aux) {
	        long count = 0;
	        int i = lo, j = mid + 1, k = lo;
	        while (i <= mid || j <= hi) {
	            if (i > mid) {
	                arr[k++] = aux[j++];
	            } else if (j > hi) {
	                arr[k++] = aux[i++];
	            } else if (aux[i] <= aux[j]) {
	                arr[k++] = aux[i++];
	            } else {
	                arr[k++] = aux[j++];
	                count += mid + 1 - i;
	            }
	        }

	        return count;
	    }
	public static void main(String[] args) {
		int[] a = {1,2,3,4,9,11,2,3};
		countInversions(a);
	}
}
