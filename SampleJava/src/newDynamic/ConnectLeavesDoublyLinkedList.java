package newDynamic;

public class ConnectLeavesDoublyLinkedList {
	Node prev = null;
	Node head = null;
	Node extractLeaves(Node root)
	{
		if(root == null)
		{
			return null;
		}
		else if(root.left == null && root.right == null)
		{
			if(head == null)
			{
				head = root;
				prev = root;
			}
			else
			{
				prev.right = root;
				root.left = prev;
				prev = root;
			}
			return null;
		}
		root.left = extractLeaves(root.left);
		root.right = extractLeaves(root.right);
		return root;
	}
	void inorder(Node node) 
    {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
	 public void printDLL(Node head) 
	    {
	        Node last = null;
	        while (head != null) 
	        {
	            System.out.print(head.data + " ");
	            last = head;
	            head = head.right;
	        }
	    }
	public static void main(String[] args) {
		ConnectLeavesDoublyLinkedList obj = new ConnectLeavesDoublyLinkedList();
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
  
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);
     
        System.out.println("Inorder traversal of given obj is : ");
        obj.inorder(root);
        obj.extractLeaves(root);
        System.out.println("");
        System.out.println("Extracted double link list is : ");
        obj.printDLL(obj.head);
        System.out.println("");
        System.out.println("Inorder traversal of modified obj is : ");
        obj.inorder(root);
	}
}
