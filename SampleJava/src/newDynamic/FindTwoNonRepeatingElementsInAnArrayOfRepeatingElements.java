package newDynamic;

public class FindTwoNonRepeatingElementsInAnArrayOfRepeatingElements {
	void printNonRepeatingNums(int[] arr)
	{
		int xor = 0;
		int length = arr.length;
		for(int i=0;i<length;i++)
		{
			xor ^= arr[i];
		}
		int x=0;
		int y=0;
		xor = xor & -xor;
		for(int i = 0; i < length; i++)
		  {
		    if((arr[i] & xor) != 0 )
		     x = x ^ arr[i]; /*XOR of first set */
		    else
		     y = y ^ arr[i]; /*XOR of second set*/
		  }
		System.out.println(x+ " "+ y);
	}
	public static void main(String[] args) {
		FindTwoNonRepeatingElementsInAnArrayOfRepeatingElements obj = new FindTwoNonRepeatingElementsInAnArrayOfRepeatingElements();
		int[] arr = {2, 3, 7, 9, 11, 2, 3, 11};
		obj.printNonRepeatingNums(arr);
		
	}
}
