package amazone;
//A binary tree Nodex
class Nodex 
{
 int data;
 Nodex left, right;

 Nodex(int item) 
 {
     data = item;
     left = right = null;
 }
}

class Values 
{
 int max, min;
}

class PrintBinaryTreeVerticalOrder 
{
 Nodex root;
 Values val = new Values();

 // A utility function to find min and max distances with respect
 // to root.
 void findMinMax(Nodex Nodex, Values min, Values max, int hd) 
 {
     // Base case
     if (Nodex == null) 
         return;

     // Update min and max
     if (hd < min.min) 
         min.min = hd;
     else if (hd > max.max) 
         max.max = hd;

     // Recur for left and right subtrees
     findMinMax(Nodex.left, min, max, hd - 1);
     findMinMax(Nodex.right, min, max, hd + 1);
 }

 // A utility function to print all Nodexs on a given line_no.
 // hd is horizontal distance of current Nodex with respect to root.
 void printVerticalLine(Nodex Nodex, int line_no, int hd) 
 {
     // Base case
     if (Nodex == null) 
         return;

     // If this Nodex is on the given line number
     if (hd == line_no) 
         System.out.print(Nodex.data + " ");        

     // Recur for left and right subtrees
     printVerticalLine(Nodex.left, line_no, hd - 1);
     printVerticalLine(Nodex.right, line_no, hd + 1);
 }

 // The main function that prints a given binary tree in
 // vertical order
 void verticalOrder(Nodex Nodex) 
 {
     // Find min and max distances with resepect to root
     findMinMax(Nodex, val, val, 0);

     // Iterate through all possible vertical lines starting
     // from the leftmost line and print Nodexs line by line
     for (int line_no = val.min; line_no <= val.max; line_no++) 
     {
         printVerticalLine(Nodex, line_no, 0);
         System.out.println("");
     }
 }

 // Driver program to test the above functions
 public static void main(String args[]) 
 {
     PrintBinaryTreeVerticalOrder tree = new PrintBinaryTreeVerticalOrder();

     /* Let us construct the tree shown in above diagram */
     tree.root = new Nodex(1);
     tree.root.left = new Nodex(2);
     tree.root.right = new Nodex(3);
     tree.root.left.left = new Nodex(4);
     tree.root.left.right = new Nodex(5);
     tree.root.right.left = new Nodex(6);
     tree.root.right.right = new Nodex(7);
     tree.root.right.left.right = new Nodex(8);
     tree.root.right.right.right = new Nodex(9);

     System.out.println("vertical order traversal is :");
     tree.verticalOrder(tree.root);
 }
}