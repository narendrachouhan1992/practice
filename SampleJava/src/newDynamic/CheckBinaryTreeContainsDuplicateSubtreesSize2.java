package newDynamic;

import java.util.HashSet;;

public class CheckBinaryTreeContainsDuplicateSubtreesSize2 {
	 
    /* A binary tree node has data, pointer to
    left child and a pointer to right child */
    static HashSet<String> subtrees = new HashSet<String>();;
    static String MARKER = "$";
    static String dupSubUtil(Node root)
    {
    	String s = "";
    	 
        // If current node is NULL, return marker
        if (root == null)
            return s + MARKER;
     
        // If left subtree has a duplicate subtree.
        String lStr = dupSubUtil(root.left);
        if (lStr.equals(s))
           return s;
     
        // Do same for right subtree
        String rStr = dupSubUtil(root.right);
        if (rStr.equals(s))
           return s;
     
        // Serialize current subtree
        s = s + root.data + lStr + rStr;
     
        // If current subtree already exists in hash
        // table. [Note that size of a serialized tree
        // with single node is 3 as it has two marker
        // nodes.
        if (s.length() > 3 &&
            subtrees.contains(s))
           return "";
     
        subtrees.add(s);
     
        return s;
    }
    // Driver code
    public static void main(String args[])
    {
        Node root = null;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.right = new Node(4);
        if(dupSubUtil(root) == "")
        {
        	System.out.println("yes");
        }
        else
        {
        	System.out.println("No");
        }
    }

}