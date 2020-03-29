package newDynamic;

public class FindTwoRectanglesOverlap {
	boolean isOverlape(Point l1, Point r1, Point l2, Point r2)
	{
		if (l1.x > r2.x || l2.x > r1.x)
	        return false;
	 
	    // If one rectangle is above other
	    if (l1.y < r2.y || l2.y < r1.y)
	        return false;
	 
	    return true;
	}
	public static void main(String[] args) {
		Point l1 = new Point(0, 10);
		Point r1 = new Point(10, 0);
	    Point l2 = new Point(5, 5);
	    Point r2 = new Point(15, 0);
	    FindTwoRectanglesOverlap obj = new FindTwoRectanglesOverlap();
	    System.out.println(obj.isOverlape(l1, r1, l2, r2)? "True": "false");
	}
}
