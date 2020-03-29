package newDynamic;

public class ConnectNodesAtSameLevelWithO1ExtraSpace {
	void connectNext(Node curr)
	{
		if(curr == null)
			return;
		if(curr.right_next!= null)
			connectNext(curr.right_next);
		if(curr.left!= null)
		{
			if(curr.right!= null)
			{
				curr.left.right_next = curr.right;
				curr.right.right_next = getNextRight(curr);
				
			}
			else
			{
				curr.left.right_next = getNextRight(curr);
			}		
			connectNext(curr.left);
		}
		else if(curr.right!= null)
		{
			curr.right_next = getNextRight(curr);
			connectNext(curr.right);
		}
		else
		{
			connectNext(curr.right_next);
		}
	}
	Node getNextRight(Node curr)
	{
		Node temp = curr.right_next;
		while(temp!= null)
		{
			if (temp.left != null)
                return temp.left;
            if (temp.right != null)
                return temp.right;
            temp = temp.right_next;
		}
		return null;
	}
	public static void main(String[] args) {
		ConnectNodesAtSameLevelWithO1ExtraSpace obj = new ConnectNodesAtSameLevelWithO1ExtraSpace();
		Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.right = new Node(90);
        obj.connectNext(root);
	}
}
