package newDynamic;

class NodeLL
{
	int data;
	NodeLL right;
	NodeLL down;
	public NodeLL(int data) {
		super();
		this.data = data;
	}
}
public class FlatteningALinkedList {
	NodeLL merge(NodeLL a, NodeLL b)
	{
		if(a== null)
			return b;
		if(b==null)
			return a;
		NodeLL res = null;
		if(a.data>b.data)
		{
			res = b;
			res.down = merge(a, b.down);
		}
		else
		{
			res = a;
			res.down = merge(a.down, b);
		}
		return res;
	}
	NodeLL flattenLL(NodeLL root)
	{
		if(root == null || root.right== null)
			return root;
		root.right = flattenLL(root.right);
		return merge(root, root.right);
	}
	void printLL(NodeLL root)
	{
		if(root == null)
			return;
		System.out.println(root.data);
		printLL(root.down);
	}
	public static void main(String[] args) {
		 /* Let us create the following linked list
	       5 -> 10 -> 19 -> 28
	       |    |     |     |
	       V    V     V     V
	       7    20    22    35
	       |          |     |
	       V          V     V
	       8          50    40
	       |                |
	       V                V
	       30               45
	    */
		FlatteningALinkedList obj = new FlatteningALinkedList();
		NodeLL ll =  new NodeLL(5);
		ll.down = new NodeLL(7);
		ll.down.down  = new NodeLL(8);
		ll.down.down.down  = new NodeLL(30);
		ll.right = new NodeLL(10);
		ll.right.down = new NodeLL(20);
		ll.right.right = new NodeLL(19);
		ll.right.right.down = new NodeLL(22);
		ll.right.right.down.down = new NodeLL(50);
		ll.right.right.right = new NodeLL(28);
		ll.right.right.right.down = new NodeLL(35);
		ll.right.right.right.down.down  = new NodeLL(40);
		ll.right.right.right.down.down.down = new NodeLL(45);
		
		obj.flattenLL(ll);
		obj.printLL(ll);
	}
}
