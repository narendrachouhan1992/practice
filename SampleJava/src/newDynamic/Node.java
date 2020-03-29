package newDynamic;

class Node 
{
    int data;
    int hd;
    int height;
    
    Node left, right, random, right_next;
    int covered= 0;
  
    Node(int item) 
    {
        data = item;
        left = right = null;
    }
    public Node() {
		// TODO Auto-generated constructor stub
	}
}