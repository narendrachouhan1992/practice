package GeeksForGeeks;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadderProb {
	class QNode
	{
		int curr;
		int count;
	}
	int getMinStep(int[] arr)
	{
		int n = arr.length;
		boolean[] visited = new boolean[n];
		
		
		Queue<QNode> q = new LinkedList();
		
		QNode node = new QNode();
		node.curr = 0;
		node.count = 0;
		q.add(node);
		visited[0] = true;
		while(!q.isEmpty())
		{
			QNode st = q.peek();
			if(st.curr == n-1)
				break;
			q.remove();
			for(int i=1;i<=6 && st.curr+i<n;i++)
			{
				if(!visited[st.curr+i])
				{
					QNode next = new QNode();
					next.count=st.count+1;
					visited[st.curr+i] = true;
					next.curr = arr[st.curr+i];
					q.add(next);
				}
			}
		}
		return q.peek().count;
		
	}
}
