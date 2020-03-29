package newDynamic;

import java.util.Stack;

public class FindAPairWithGivenSumInBst {
	boolean getNums(Node root, int target)
	{
		Stack< Node> s1 = new Stack<Node>();
		boolean done1 = false;
		boolean done2 = false;
		Stack< Node> s2 = new Stack<Node>();
		Node curr1= root;
		Node curr2 = root;
		int val1 = 0;
		int val2 = 0;
		while(true)
		{
			while(!done1)
			{
				if(curr1!= null)
				{
					s1.push(curr1);
					curr1= curr1.left;
				}
				else
				{
					if(!s1.isEmpty())
					{
						curr1 = s1.pop();
						val1 = curr1.data;
						curr1 = curr1.right;
						done1 = true;
					}
					else
					{
						done1 = true;
					}
				}
				
			}
			while(!done2)
			{
				if(curr2!= null)
				{
					s2.push(curr2);
					curr2= curr2.right;
				}
				else
				{
					if(!s2.isEmpty())
					{
						curr2 = s2.pop();
						val2 = curr2.data;
						curr2 = curr2.left;
						done2 = true;
					}
					else
					{
						done2 = true;
					}
				}
				
			}
			if(val1 != val2 && val1+val2 == target)
			{
				System.out.println("Pairs found "+ val1+ " "+val2);
				return true;
			}
			else if(val1+val2<target)
			{
				done1= false;
			}
			else if(val1+val2 <target)
			{
				done2 = false;
			}
			if(val1>val2)
				return false;
			
		}
	}
	public static void main(String[] args) {
//			        15
//			        /     \
//			      10      20
//			     / \     /  \
//			    8  12   16  25    */
			Node root =  new Node(15);
			root.left = new Node(10);
			root.right = new Node(20);
			root.left.left = new Node(8);
			root.left.right = new Node(12);
			root.right.left = new Node(16);
			root.right.right = new Node(25);
			FindAPairWithGivenSumInBst obj = new FindAPairWithGivenSumInBst();
			obj.getNums(root, 33);
	}
}
