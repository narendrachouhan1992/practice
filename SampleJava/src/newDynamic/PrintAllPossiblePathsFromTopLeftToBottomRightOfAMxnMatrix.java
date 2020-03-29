package newDynamic;

import java.util.Arrays;

public class PrintAllPossiblePathsFromTopLeftToBottomRightOfAMxnMatrix {
	   public void print(int arr[][],int row, int col,int result[],int pos){
		   
	       if(arr.length==row+1 && arr[0].length==col+1)
	       {
	    	   result[pos] = arr[row][col];
	    	   System.out.println(Arrays.toString(result));
	    	   return;
	       }
	       if(row >= arr.length || col>=arr[0].length) {
	    	   return ;
	       }
	       result[pos] = arr[row][col];
	       print(arr, row+1, col, result, pos+1);
	       print(arr, row, col+1, result, pos+1);
	    }
	    
	    public static void main(String args[]){
	    	PrintAllPossiblePathsFromTopLeftToBottomRightOfAMxnMatrix pam = new PrintAllPossiblePathsFromTopLeftToBottomRightOfAMxnMatrix();
	        int arr[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
	        int result[] = new int[arr.length + arr[0].length-1];
	        pam.print(arr, 0, 0, result,0);
	    }
}
