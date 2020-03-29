package newDynamic;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {
	void connect(Node root)
	{
		if(root == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty())
		{
			int levelcount = q.size();
			while(levelcount!= 1)
			{
				Node temp = q.poll();
				temp.right_next = q.peek();
				if(temp.left!= null)
					q.add(temp.left);
				if(temp.right!= null)
					q.add(temp.right);
				levelcount--;
			}
			Node temp = q.poll();
			temp.right_next = null;
			if(temp.left!= null)
				q.add(temp.left);
			if(temp.right!= null)
				q.add(temp.right);
			levelcount--;			
		}
	}
	
	public static void main(String[] args) {
		ConnectNodesAtSameLevel obj = new ConnectNodesAtSameLevel();
		Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.right = new Node(90);
        
      obj.connect(root);
      System.out.println(root);
	}
}
