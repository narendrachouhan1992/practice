package amazone;

import java.util.Deque;
import java.util.LinkedList;

import javax.swing.plaf.SliderUI;

public class SlidingWindowMaximumMaximumOfAllSubarraysOfSizeK {
	void getMax(int[] arr, int k)
	{
		int n = arr.length;
		Deque<Integer> dqueue = new LinkedList<Integer>();
		int i;
		for(i=0;i<k;i++)
		{
			while(!dqueue.isEmpty() && arr[dqueue.peekLast()] <= arr[i])
				dqueue.removeLast();
			dqueue.addLast(i);
		}
		for(;i<n;i++)
		{
			System.out.print(arr[dqueue.peek()] +"  ");
			
			while(!dqueue.isEmpty() && dqueue.peek()<=i-k)
				dqueue.removeFirst();
			
			while(!dqueue.isEmpty() && arr[i] >= arr[dqueue.peekLast()])
				dqueue.removeLast();
			dqueue.addLast(i);	
		}
		System.out.print(arr[dqueue.peek()]);
	}
	public static void main(String[] args) {
		SlidingWindowMaximumMaximumOfAllSubarraysOfSizeK obj = new SlidingWindowMaximumMaximumOfAllSubarraysOfSizeK();
		int[] arr= {12, 1, 78, 90, 57, 89, 56};
        int k=3;
        obj.getMax(arr, k);
	}
}
