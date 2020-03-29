package newDynamic;


import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class BottomViewBinaryTree {
	void printBottomView(Node root)
	{
		Queue<Node> q = new LinkedList<Node>();
		int hd = 0;
		Map<Integer, Integer> map = new TreeMap<>();
		root.hd = hd;
		q.add(root);
		while(!q.isEmpty())
		{
			Node temp = q.poll();
			hd = temp.hd;
			map.put(temp.hd, temp.data);
			if(temp.left!= null)
			{
				temp.left.hd = hd-1;
				q.add(temp.left);
			}
			if(temp.right != null)
			{
				temp.right.hd = hd+1;
				q.add(temp.right);
			}
		}
		Set<Entry<Integer, Integer>> set = map.entrySet();
		for (Entry<Integer, Integer> entry : set) {
			System.out.println(entry.getValue());
		}
	}
	public static void main(String[] args) {
		BottomViewBinaryTree obj = new BottomViewBinaryTree();	
		Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        System.out.println("Bottom view of the given binary tree:");
	    obj.printBottomView(root);
	}
}
