package HackerRank.Sort;

import java.util.HashMap;
import java.util.Map;

public class FraudulentActivity {
	static class Node
	{
		int val;
		Node next;
		Node prev;
	}
	
	static int activityNotifications0(int[] expenditure, int d) {
		int res = 0;
		if(d>=expenditure.length)
			return 0;
		Map<Integer, Node> map = new HashMap<Integer, Node>();
		Node linkedList = null;
		int i;
		for(i=0;i<d;i++)
		{
			if(linkedList==null)
			{
				linkedList = new Node();
				map.put(i, linkedList);
				linkedList.val = expenditure[i];
			}
			else
			{
				Node curr = linkedList;
				while(curr.next!=null && curr.next.val<expenditure[i])
					curr = curr.next;
				Node next = curr.next;
				curr.next = new Node();
				curr.next.val = expenditure[i];
				curr.next.next = next;
				curr.next.prev = curr;
				if(next!=null)
				{
					
					next.prev = curr.next;
				}

				map.put(i,curr.next);
			}
		}
		int count = 0;
		Node mid = linkedList;
		while(count<d/2)
		{
			mid = mid.next;
			count++;
		}
		while(i<expenditure.length)
		{
		
			int midnum = -1;
			if(d%2==0)
			{
				midnum= mid.val+mid.prev.val;
				midnum/=2;
			}
			else
				midnum = mid.val;
 			if(midnum*2>expenditure[i])
			{
				res++;
			}
 			Node rem = map.get(i-d);
 			if(rem==linkedList)
 			{
 				linkedList = linkedList.next;
 				linkedList.prev=null;
 				rem.next=null;
 				rem.prev = null;
 			}
 			else
 			{
 				if(rem.prev!=null)
 					rem.prev.next = rem.next;
 				if(rem.next!=null)
 					rem.next.prev = rem.prev;
 				rem.next= null;
 				rem.prev = null;
 			}
			Node curr = linkedList;
			while(curr.next!=null && curr.next.val<expenditure[i])
				curr = curr.next;
			Node next = curr.next;
			curr.next = new Node();
			curr.next.val = expenditure[i];
			curr.next.next = next;
			curr.next.prev = curr;
			if(next!=null)
			{
			
				next.prev = curr.next;
			}
			map.put(i,curr.next);
			count = 0;
			mid = linkedList;
			while(count<d/2)
			{
				mid = mid.next;
				count++;
			}
			i++;
		}
		
		return res;
	}
	  static int activityNotifications(int[] expenditure, int d) {;

      int notificationCount = 0;

      int[] data = new int[201];
      for (int i = 0; i < d; i++) {
          data[expenditure[i]]++;
      }

      for (int i = d; i < expenditure.length; i++) {

          double median = getMedian(d, data);

          if (expenditure[i] >= 2 * median) {
              notificationCount++;

          }

          data[expenditure[i]]++;
          data[expenditure[i - d]]--;

      }

      return notificationCount;

  }

  private static double getMedian(int d, int[] data) {
      double median = 0;
      if (d % 2 == 0) {
          Integer m1 = null;
          Integer m2 = null;
          int count = 0;
          for (int j = 0; j < data.length; j++) {
              count += data[j];
              if (m1 == null && count >= d/2) {
                  m1 = j;
              }
              if (m2 == null && count >= d/2 + 1) {
                  m2 = j;
                  break;
              }
          }
          median = (m1 + m2) / 2.0;
      } else {
          int count = 0;
          for (int j = 0; j < data.length; j++) {
              count += data[j];
              if (count > d/2) {
                  median = j;
                  break;
              }
          }
      }
      return median;
  }
	public static void main(String[] args) {
		int[] arr = {1 ,2, 3, 4, 4};
		System.out.println(activityNotifications(arr, 4));
	}
	

}
