package geeksForGeeks;

public class WriteCCodeToDetermineIfTwoTreesAreIdentical {
	boolean isIdentical(Node first, Node second)
	{
		if(first==null && second ==null)
			return true;
		else if(first==null || second == null)
		{
			return false;
		}
		else
		{
				return ((first.data== second.data) && isIdentical(first.left, second.left) && isIdentical(first.right, second.right));
		}
	}
	public static void main(String[] args)  
    { 
   
        Node root1 = new Node(1); 
        root1.left = new Node(2); 
        root1.right = new Node(3); 
        root1.left.left = new Node(4); 
        root1.left.right = new Node(5); 
   
        Node root2 = new Node(1); 
        root2.left = new Node(2); 
        root2.right = new Node(3); 
        root2.left.left = new Node(4); 
        root2.left.right = new Node(5); 
        WriteCCodeToDetermineIfTwoTreesAreIdentical obj = new WriteCCodeToDetermineIfTwoTreesAreIdentical();
        if (obj.isIdentical(root1, root2)) 
            System.out.println("Both s are identical"); 
        else
            System.out.println("s are not identical"); 
   
    } 
}
