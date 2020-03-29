package newDynamic;

import java.util.Stack;

public class PrintCommonNodesInTwoBinarySearchTrees {
	void printCommonNode(Node root1,Node root2)
	{
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		while(true)
		{
			if(root1 != null)
			{
				s1.push(root1);
				root1=root1.left;
			}
			else if(root2 != null)
			{
				s2.push(root2);
				root2=root2.left;
			}
			else if(!s1.isEmpty() && !s2.isEmpty())
			{
				root1 = s1.peek();
				root2 = s2.peek();
				if(root1.data == root2.data)
				{
					System.out.print(root1.data+ " ");
					s1.pop();
					s2.pop();
					root1 = root1.right;
					root2 = root2.right;
				}
				else if(root1.data > root2.data)
				{
					s2.pop();
					root2 = root2.right;
					root1 = null;
				}
				else
				{
					s1.pop();
					root1 = root1.right;
					root2 = null;
				}
			}
			else
			{
				break;
			}
		}
	}
	public static void main(String[] args) {
		PrintCommonNodesInTwoBinarySearchTrees obj = new PrintCommonNodesInTwoBinarySearchTrees();
		Node root1 = new Node(5);
	    root1.left = new Node(1);
	    root1.right = new Node(10);
	    root1.left.left = new Node( 0);
	    root1.left.right = new Node( 4);
	    root1.right.left = new Node( 7);
	    root1.right.left.right = new Node( 9);
	 
	    // Create second tree as shown in example
	    Node root2 = new Node(10);
	    root2.left = new Node(7);
	    root2.right = new Node(20);
	    root2.left.left = new Node(4);
	    root2.left.right = new Node(9);
	    obj.printCommonNode(root1, root2);
	    
	}
}
