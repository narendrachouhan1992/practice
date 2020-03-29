package GeeksForGeeks;

import java.util.Arrays;

class Node1
{
	int val;
	Node down;
	Node right;
}
public  class IncreasingDecreas {
	static void getNum(String s)
	{
		int n = s.length();
		int high = 0;
		int low = 0;
		int[] arr = new int[n+1];
		arr[0] = 0;
		int index = 0;
		for(int i=0;i<n;i++)
		{
			if(s.charAt(i)=='I')
			{
				arr[++index]=++high;
			} 
			else
			{
				arr[++index]=--low;
			}
		}
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i]+Math.abs(low);
		}
		System.out.println(Arrays.toString(arr));
	}
	static int findoptimal(int N) 
    { 
        // The optimal string length is N 
        // when N is smaller than 7 
        if (N <= 6) 
            return N; 
  
        // An array to store result 
        // of subproblems 
        int screen[] = new int[N+1]; 
  
        int b; // To pick a breakpoint 
  
        // Initializing the optimal lengths 
        // array for uptil 6 input strokes 
        int n; 
        for (n = 1; n <= 6; n++) 
            screen[n] = n; 
  
        // Solve all subproblems in bottom manner 
        for (n = 7; n <= N; n++) { 
            // Initialize length of optimal 
            // string for n keystrokes 
            screen[n] = 0; 
  
            // For any keystroke n, we need 
            // to loop from n-3 keystrokes 
            // back to 1 keystroke to find 
            // a breakpoint 'b' after which we 
            // will have ctrl-a, ctrl-c and 
            // then only ctrl-v all the way. 
            for (b = n - 3; b >= 1; b--) { 
                // if the breakpoint is 
                // at b'th keystroke then 
                // the optimal string would 
                // have length 
                // (n-b-1)*screen[b-1]; 
                int curr = (n - b-1) * screen[b]; 
                if (curr > screen[n]) 
                    screen[n] = curr; 
            } 
        } 
  
        return screen[N - 1]; 
    } 
	public static void main(String[] args) {
		getNum("DDIDDIID");
//		DDIDDIID Output: 321654798 

	}
}
