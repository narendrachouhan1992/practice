package HackerRank;

import java.util.ArrayList;
import java.util.List;

public class LCMGCD {
	public static int getTotalX(List<Integer> a, List<Integer> b) {
		
		
		return 1;
    } 
	
	private static int gcd(int a, int b) {
	        while (b > 0) {
	            int temp = b;
	            b = a % b; // % is remainder
	            a = temp;
	        }
	        return a;
	    }

	    private static int gcd(int[] input) {
	        int result = input[0];
	        for (int i = 1; i < input.length; i++) {
	            result = gcd(result, input[i]);
	        }
	        return result;
	    }

	    private static int lcm(int a, int b) {
	        return a * (b / gcd(a, b));
	    }

	    private static int lcm(int[] input) {
	        int result = input[0];
	        for (int i = 1; i < input.length; i++) {
	            result = lcm(result, input[i]);
	        }
	        return result;
	    }
}
