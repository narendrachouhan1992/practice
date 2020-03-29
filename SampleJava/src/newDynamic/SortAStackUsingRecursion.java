package newDynamic;

import java.util.ListIterator;
import java.util.Stack;

public class SortAStackUsingRecursion {
	void sortUsingRec(Stack<Integer> s)
	{
		 if (!s.isEmpty())
	        {
	            // Remove the top item
	            int x = s.pop();
	      
	            // Sort remaining stack
	            sortUsingRec(s);
	      
	            // Push the top item back in sorted stack
	            insertSorted(s, x);
	        }
	}
	void insertSorted(Stack<Integer> s, int x)
	{
		// Base case: Either stack is empty or newly inserted
        // item is greater than top (more than all existing)
        if (s.isEmpty() || x > s.peek())
        {
            s.push(x);
            return;
        }
      
        // If top is greater, remove the top item and recur
        int temp = s.pop();
        insertSorted(s, x);
      
        // Put back the top item removed earlier
        s.push(temp);
	}
	void printStack(Stack<Integer> s)
    {
       ListIterator<Integer> lt = s.listIterator();
        
       // forwarding
       while(lt.hasNext())
           lt.next();
        
       // printing from top to bottom
       while(lt.hasPrevious())
           System.out.print(lt.previous()+" ");
    }
	public static void main(String[] args) {
		SortAStackUsingRecursion obj = new SortAStackUsingRecursion();
		Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);
      
        System.out.println("Stack elements before sorting: ");
        obj.printStack(s);
      
        obj.sortUsingRec(s);
      
        System.out.println(" \n\nStack elements after sorting:");
        obj.printStack(s);
	}
}
