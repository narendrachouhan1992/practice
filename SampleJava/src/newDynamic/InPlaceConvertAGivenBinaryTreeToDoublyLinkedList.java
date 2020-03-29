package newDynamic;

public class InPlaceConvertAGivenBinaryTreeToDoublyLinkedList {
	Node convertBSTtoDLL(Node root)
	{
		if(root==null)
			return null;
		if(root.left!= null)
		{
			Node left = convertBSTtoDLL(root.left);
			while(left!= null && left.right!= null)
			{
				left = left.right;
			}
			left.right = root;
			root.left = left;
		}
		if(root.right!= null)
		{
			Node right = convertBSTtoDLL(root.right);
			while(right!= null && right.left!= null)
			{
				right = right.left;
			}
			right.left = root;
			root.right = right;
		}
		return root;
	}
	Node getDLLfromBST(Node root)
	{
		root = convertBSTtoDLL(root);
		while(root.left!= null)
			root = root.left;
		return root;
	}
	void print(Node root)
	{
		if(root == null)
			return;
		System.out.print(root.data+" ");
		print(root.right);
	}
	public static void main(String[] args) {
		InPlaceConvertAGivenBinaryTreeToDoublyLinkedList obj = new InPlaceConvertAGivenBinaryTreeToDoublyLinkedList();
		 // Let us create the tree shown in above diagram
       Node root = new Node(10);
       root.left = new Node(12);
       root.right = new Node(15);
       root.left.left = new Node(25);
       root.left.right = new Node(30);
       root.right.left = new Node(36);
       root = obj.getDLLfromBST(root);
       obj.print(root);
	}
}
