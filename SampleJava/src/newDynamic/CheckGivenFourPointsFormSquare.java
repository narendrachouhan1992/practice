package newDynamic;

public class CheckGivenFourPointsFormSquare {
	int getDistanceSquare(Point p1, Point p2)
	{
		return (p1.x* -p2.x)*(p1.x* -p2.x) + (p1.y - p2.y)*(p1.y - p2.y);
	}
	boolean isSquare(Point p1, Point p2, Point p3, Point p4)
	{
		int d2 = getDistanceSquare(p1, p2);
		int d3 = getDistanceSquare(p1, p3);
		int d4 = getDistanceSquare(p1, p4);
		if(d2==d3 && d2*2 == d4)
		{
			int d = getDistanceSquare(p2, p4);
			return (d == getDistanceSquare(p3, p4) && d == d2); 
		}
		if (d3 == d4 && 2*d3 == d2)
	    {
	        int d = getDistanceSquare(p2, p3);
	        return (d == getDistanceSquare(p2, p4) && d == d3);
	    }
	    if (d2 == d4 && 2*d2 == d3)
	    {
	        int d = getDistanceSquare(p2, p3);
	        return (d == getDistanceSquare(p3, p4) && d == d2);
	    }
		return false;
	}
	public static void main(String[] args) {
		Point p1 = new Point(20, 10);
		Point p2 = new Point(10, 20);
		Point p3 = new Point(20, 20);
		Point p4 = new Point(10, 10);
		CheckGivenFourPointsFormSquare obj = new CheckGivenFourPointsFormSquare();
	    if(obj.isSquare(p1, p2, p3, p4))
		{
			System.out.println("yes");
		}
	    else
	    {
	    	System.out.println("No");
	    }
	}
}
