package newDynamic;

public class CheckIfTwoTreesAreMirror {
	boolean isMirror(Node t1, Node t2)
	{
		if(t1== null && t2== null)
			return true;
		if(t1== null || t2== null)
			return false;
		return (isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left) && (t1.data==t2.data));
	}
	public static void main(String[] args) {
		CheckIfTwoTreesAreMirror obj = new CheckIfTwoTreesAreMirror();
		Node root = new Node(26);
		root.left = new Node(10);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.right = new Node(3);
        
        Node root2 = new Node(26);
		root2.left = new Node(3);
        root2.right = new Node(10);
        root2.left.left = new Node(3);
        root2.right.left = new Node(6);
        root2.right.right = new Node(4);
        if (obj.isMirror(root, root2)) 
        {
        	System.out.println("yes");
        } else
        {
        	System.out.println("NO");
        }
	}
}
