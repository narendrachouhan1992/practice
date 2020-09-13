package HackerRank.search;

import java.util.Arrays;

public class TripleSum {
	static long triplets(int[] a, int[] b, int[] c) {
	    int[] arr = Arrays.stream(a).sorted().distinct().toArray();
	    int[] brr = Arrays.stream(b).sorted().distinct().toArray();
	    int[] crr = Arrays.stream(c).sorted().distinct().toArray();

	    int x, y, z;
	    x = y = z = 0;
	    long count = 0;
	    while(y < brr.length) {
	        while(x < arr.length && arr[x] <= brr[y])
	            x++;

	        while(z < crr.length && crr[z] <= brr[y])
	            z++;
	        
	        long xl = x;
	        long zl = z;
	        count += xl * zl;
	        y++;
	    }
	    System.out.println(count);
	    return count;
	}
	
}
