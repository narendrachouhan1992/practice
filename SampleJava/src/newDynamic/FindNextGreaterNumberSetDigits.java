package newDynamic;

import java.util.Arrays;

public class FindNextGreaterNumberSetDigits {
	void swap(char ar[], int i, int j) 
    {
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
	int  findNext(int num) 
    {
		char  ar[] = Integer.toString(num).toCharArray();
        int i;
        int n = ar.length;
        // I) Start from the right most digit 
        // and find the first digit that is smaller 
        // than the digit next to it.
        for (i = n - 1; i > 0; i--) 
        {
            if (ar[i] > ar[i - 1]) {
                break;
            }
        }
         
        // If no such digit is found, then all 
        // digits are in descending order means 
        // there cannot be a greater number with 
        // same set of digits
        if (i == 0) 
        {
            System.out.println("Not possible");
            return -1;
        } 
        else
        {
        	int x = ar[i - 1], min = i;
            
            // II) Find the smallest digit on right 
            // side of (i-1)'th digit that is greater 
            // than number[i-1]
            for (int j = i + 1; j < n; j++) 
            {
                if (ar[j] > x && ar[j] < ar[min]) 
                {
                    min = j;
                }
            }
            swap(ar, i - 1, min);
 
            // IV) Sort the digits after (i-1) 
            // in ascending order
            Arrays.sort(ar, i, n);
            System.out.print("Next number with same" +
                                    " set of digits is ");
            return Integer.parseInt(String.copyValueOf(ar));
        }
    }
	public static void main(String[] args) {
		FindNextGreaterNumberSetDigits obj = new FindNextGreaterNumberSetDigits();
		
		System.out.println(obj.findNext(454));
	}
}
