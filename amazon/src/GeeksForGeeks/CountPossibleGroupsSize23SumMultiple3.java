package GeeksForGeeks;

public class CountPossibleGroupsSize23SumMultiple3 {
	static int getCombination(int[] arr)
	{
		int size = arr.length;
		int[] c = new int[3];
		for(int i=0;i<size;i++)
		{
			c[arr[i]%3]++;
		}
		int res = 0;
		// Case 3.a: Count groups of size 2 from 0 remainder elements 
        res += ((c[0] * (c[0] - 1)) >> 1); 
  
        // Case 3.b: Count groups of size 2 with one element with 1 
        // remainder and other with 2 remainder 
        res += c[1] * c[2]; 
  
        // Case 4.a: Count groups of size 3 with all 0 remainder elements 
        res += (c[0] * (c[0] - 1) * (c[0] - 2)) / 6; 
  
        // Case 4.b: Count groups of size 3 with all 1 remainder elements 
        res += (c[1] * (c[1] - 1) * (c[1] - 2)) / 6; 
  
        // Case 4.c: Count groups of size 3 with all 2 remainder elements 
        res += ((c[2] * (c[2] - 1) * (c[2] - 2)) / 6); 
  
        // Case 4.c: Count groups of size 3 with different remainders 
        res += c[0] * c[1] * c[2]; 
  
        // Return total count stored in res 
        return res; 
		
	}
	public static void main(String[] args) {
		 int arr[] = {3, 6, 7, 2, 9};;
		 System.out.println(getCombination(arr));
	}
}
