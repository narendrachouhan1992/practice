package newDynamic;

import java.util.Stack;

public class FormMinimumNumberFromGivenSequence {
	void PrintMinNumberForPattern(String arr)
	{
	    // Initialize current_max (to make sure that
	    // we don't use repeated character
	    int curr_max = 0;
	 
	    // Initialize last_entry (Keeps track for
	    // last printed digit)
	    int last_entry = 0;
	 
	    int j;
	 
	    // Iterate over input array
	    for (int i=0; i<arr.length(); i++)
	    {
	        // Initialize 'noOfNextD' to get count of
	        // next D's available
	        int noOfNextD = 0;
	 
	        switch(arr.charAt(i))
	        {
	        case 'I':
	            // If letter is 'I'
	 
	            // Calculate number of next consecutive D's
	            // available
	            j = i+1;
	            while (j < arr.length() && arr.charAt(j) == 'D' )
	            {
	                noOfNextD++;
	                j++;
	            }
	               
	            if (i==0)
	            {
	                curr_max = noOfNextD + 2;
	 
	                // If 'I' is first letter, print incremented
	                // sequence from 1
	                System.out.print(" "+  ++last_entry);
	                System.out.print(" " + curr_max);
	 
	                // Set max digit reached
	                last_entry = curr_max;
	            }
	            else
	            {
	                // If not first letter
	 
	                // Get next digit to print
	                curr_max = curr_max + noOfNextD + 1;
	 
	                // Print digit for I
	                last_entry = curr_max;
	                System.out.print(" " + last_entry);
	            }
	 
	            // For all next consecutive 'D' print 
	            // decremented sequence
	            for (int k=0; k<noOfNextD; k++)
	            {
	                System.out.print(" " + --last_entry);
	                i++;
	            }
	            break;
	 
	        // If letter is 'D'
	        case 'D':
	            if (i == 0)
	            {
	                // If 'D' is first letter in sequence
	                // Find number of Next D's available
	                j = i+1;
	                while (j < arr.length() && arr.charAt(j) == 'D')
	                {
	                    noOfNextD++;
	                    j++;
	                }
	 
	                // Calculate first digit to print based on 
	                // number of consecutive D's
	                curr_max = noOfNextD + 2;
	 
	                // Print twice for the first time
	                System.out.print(" " + curr_max + " " + (curr_max - 1));
	 
	                // Store last entry
	                last_entry = curr_max - 1;
	            }
	            else
	            {
	                // If current 'D' is not first letter
	 
	                // Decrement last_entry
	                System.out.print(" " + (last_entry - 1));
	                last_entry--;
	            }
	            break;
	        }
	    }
	    System.out.println();
	}
	void printMinNumberForPattern(String seq)
	{
	    // result store output string
	    String result = "";
	 
	    // create an empty stack of integers
	    Stack<Integer> stk = new Stack<>();
	 
	    // run n+1 times where n is length of input sequence
	    for (int i = 0; i <= seq.length(); i++)
	    {
	        // push number i+1 into the stack
	        stk.push(i + 1);
	 
	        // if all characters of the input sequence are
	        // processed or current character is 'I'
	        // (increasing)
	        if (i == seq.length() || seq.charAt(i) == 'I')
	        {
	            // run till stack is empty
	            while (!stk.empty())
	            {
	                // remove top element from the stack and
	                // add it to solution
	                result += Integer.toString(stk.peek());
	                result += " ";
	                stk.pop();
	            }
	        }
	    }
	 
	    System.out.println(result);
	}
	public static void main(String[] args) {
		FormMinimumNumberFromGivenSequence obj = new FormMinimumNumberFromGivenSequence();
		 obj.PrintMinNumberForPattern("IDIDID");
		    obj.PrintMinNumberForPattern("I");
		    obj.PrintMinNumberForPattern("DD");
		    obj.PrintMinNumberForPattern("II");
		    obj.PrintMinNumberForPattern("DIDI");
		    obj.PrintMinNumberForPattern("IIDDD");
		    obj.PrintMinNumberForPattern("DDIDDIID");
		    
		    
		    System.out.println();
		    obj.printMinNumberForPattern("I");
		    obj.printMinNumberForPattern("DD");
		    obj.printMinNumberForPattern("II");
		    obj.printMinNumberForPattern("DIDI");
		    obj.printMinNumberForPattern("IIDDD");
		    obj.printMinNumberForPattern("DDIDDIID");
	}
}
