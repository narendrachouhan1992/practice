package HackerRank;

import java.util.Arrays;
import java.util.OptionalInt;

public class MagicPotion {
	static int hurdleRace(int k, int[] height) {
		 int max =   Arrays.stream(height).max().getAsInt();
		 return max>k?max-k:0;
	}
	static int designerPdfViewer(int[] h, String word) {
		int max = 0;
		for(int i=0;i<word.length();i++)
		{
			max = Integer.max(max, h[word.charAt(i)-'a']);
		}
		return max*word.length();
    }
	 static int utopianTree(int n) {
	        int h = 1;
	        boolean d=true;
	        for(int i=0;i<n;i++)
	        {
	            if(d)
	                h *=h;
	            else
	                h+=1;
	            d = !d;
	        }
	        return h;
	    }
	 static String angryProfessor(int k, int[] a) {
		 return (int) Arrays.stream(a).filter(x->x<=0).count()<k?"YES":"NO";

	    }
	 public static void main(String[] args) {
		 int arr[] = {0, -1, 2, 1};
		 System.out.println(angryProfessor(2, arr));
	}
}
