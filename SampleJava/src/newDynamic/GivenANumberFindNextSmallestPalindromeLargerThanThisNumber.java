package newDynamic;

import java.util.Arrays;

public class GivenANumberFindNextSmallestPalindromeLargerThanThisNumber {
	void printSmallestNum(int[] num)
	{
		int length = num.length;
		int mid = length/2;
		int i = mid-1;
		int j = length%2 == 1? mid+1: mid;
		while(i>=0 && num[i] == num[j])
		{
			i--;
			j++;
		}
		boolean carryNeeded = false;
		if(i<0 || num[i]<num[j])
		{
			carryNeeded = true;
		}
		while(i>0)
		{
			num[j++] = num[i--];
		}
		if(carryNeeded)
		{
			int carry = 1;
			if (length % 2 == 1) {
                num[mid] += 1;
                carry = num[mid] / 10;
                num[mid] %= 10;
            }
			i = mid - 1;
            j = (length % 2 == 0 ? mid : mid + 1);
             while(i>=0)
             {
            	 num[i] += carry;
            	 carry = num[i]/10;
            	 num[i]%= 10;
            	 num[j++] = num[i--];
             }
		}
		System.out.println(Arrays.toString(num));
	}
	boolean AreAll9s( int[] num, int n )
	{
	    int i;
	    for( i = 0; i < n; ++i )
	        if( num[i] != 9 )
	            return false;
	    return true;
	}
	void getPalendrome(int[] num)
	{
		if(AreAll9s(num, num.length))
		{
			int length = num.length;
			System.out.print("1");
			length--;
			while(length!= 0)
			{
				System.out.print("0");
				length--;
			}
			System.out.print("1");
		}
		else
		{
			printSmallestNum(num);
		}
	}
	
	public static void main(String[] args) {
		GivenANumberFindNextSmallestPalindromeLargerThanThisNumber obj = new GivenANumberFindNextSmallestPalindromeLargerThanThisNumber();
		int[] arr = {9, 9, 9};
		int[] arr2 = {1,2,3};
		obj.getPalendrome(arr2);
	}
}
