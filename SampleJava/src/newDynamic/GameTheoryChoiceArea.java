package newDynamic;

import java.util.HashMap;
import java.util.Map;

public class GameTheoryChoiceArea {
	int getMaxUntill(int A, int B, Pair X, Pair Y, Pair Z, int last , Map<Pair, Integer> memo)
	{
		if(A<=0 || B<=0)
			return 0;
		Pair p = new Pair(A, B);
		if(memo.get(p)!= null)
			return memo.get(p);
		
		int temp = 0;
		if(last == 1)
		{
			temp = 1 + Integer.max(getMaxUntill(A+ Y.north, B + Y.south, X, Y, Z, 2, memo), getMaxUntill(A+ Z.north, B + Z.south, X, Y, Z, 3, memo));
		}
		if(last == 2)
		{
			temp = 1 + Integer.max(getMaxUntill(A+ X.north, B + X.south, X, Y, Z, 1, memo), getMaxUntill(A+ Z.north, B + Z.south, X, Y, Z, 3, memo));
		}
		if(last == 3)
		{
			temp = 1 + Integer.max(getMaxUntill(A+ Y.north, B + Y.south, X, Y, Z, 2, memo), getMaxUntill(A+ X.north, B + X.south, X, Y, Z, 1, memo));
		}
		memo.put(p, temp);
		return temp;
	}
	int getMax(int A, int B, Pair X, Pair Y, Pair Z)
	{
		if(A<=0 || B<=0)
			return 0;
		Map<Pair, Integer> memo = new HashMap<>();
		return Integer.max(Integer.max(getMaxUntill(A+X.north, B+X.south, X, Y, Z, 1, memo), getMaxUntill(A+Y.north, B+Y.south, X, Y, Z, 2, memo)), getMaxUntill(A+Z.north, B+Z.south, X, Y, Z,3, memo));
	}
	public static void main(String[] args) {
		GameTheoryChoiceArea obj = new GameTheoryChoiceArea();
		Pair X = new Pair(3, 2);
	    Pair Y = new Pair(-5, -10);
	    Pair Z = new Pair(-20, 5);
	 
	    int A = 20;
	    int B = 8;
	    System.out.println(obj.getMax(A, B, X, Y, Z));
	}
}
