package newDynamic;

import java.util.PriorityQueue;

public class ConnectNRopesMinimumCost {
	int getMinimumCost(int arr[])
	{
		int n = arr.length;
	    // Create a priority queue
	    PriorityQueue<Integer> pq =
	                        new PriorityQueue<Integer>();
	 
	    // Adding items to the pQueue
	    for(int i=0;i<n;i++)
	    {
	        pq.add(arr[i]);
	    }
	 
	    // Initialize result
	    int res = 0;
	 
	    // While size of priority queue 
	    // is more than 1
	    while (pq.size() > 1)
	    {
	        // Extract shortest two ropes from pq
	        int first = pq.poll();
	        int second = pq.poll();
	 
	        // Connect the ropes: update result
	        // and insert the new rope to pq
	        res += first + second;
	        pq.add(first + second);
	    }
	 
	    return res;
	}
	 
	public static void main(String[] args) {
		ConnectNRopesMinimumCost obj = new ConnectNRopesMinimumCost();
		int len[] = {4, 3, 2, 6};
		System.out.println(obj.getMinimumCost(len));
	}
}
