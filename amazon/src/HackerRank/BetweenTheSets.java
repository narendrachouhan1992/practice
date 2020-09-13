package HackerRank;

import java.util.List;

public class BetweenTheSets {

    private static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    private static int gcd(List<Integer> input) {
        int result = input.get(0);
        for (int i = 1; i < input.size(); i++) {
            result = gcd(result, input.get(i));
        }
        return result;
    }

    private static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    private static int lcm(List<Integer> input) {
        int result = input.get(0);
        for (int i = 1; i < input.size(); i++) {
            result = lcm(result, input.get(i));
        }
        return result;
    }
    public static int getTotalX(List<Integer> a, List<Integer> b) {
    	  int f = lcm(a);
          int l = gcd(b);
          int count = 0;
          for(int i = f, j =2; i<=l; i=f*j,j++){
              if(l%i==0){ count++;}
          }
    	return count;
    }
}
