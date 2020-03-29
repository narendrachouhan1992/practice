package newDynamic;

public class LongestConsecutiveSequenceBinaryTree {
	int res = 1;;
	void getLongest(Node root)
	{
		if(root == null)
			return;
		getLongestUntil(root.right, 1, root.data+1);
		getLongestUntil(root.left, 1, root.data+1);
	}
	void getLongestUntil(Node curr, int curr_length, int expected)
	{
		if(curr == null)
		{
			return;
		}
		if(expected == curr.data)
		{
			curr_length++;
		}
		else
		{
			curr_length = 1;
		}
		res = Integer.max(curr_length, res);
		getLongestUntil(curr.left, curr_length, curr.data+1);
		getLongestUntil(curr.right, curr_length, curr.data+1);
	}
	public static void main(String[] args) {
		LongestConsecutiveSequenceBinaryTree obj = new LongestConsecutiveSequenceBinaryTree();
		Node root = new Node(6);
	    root.right = new Node(9);
	    root.right.left = new Node(7);
	    root.right.right = new Node(10);
	    root.right.right.right = new Node(11);
	    obj.getLongest(root);
	    System.out.println(obj.res);
	}
}
