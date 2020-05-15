package tests;

public class MarioPoulin {
//	
//	(x1 , y1 ) to ( x1 + y1 , y1 ) 
//	(x1 , y1)  to  ( x1 , y1 + x1)
	static boolean isPossible(int sx, int sy, int dx, int dy) 
    { 
		if(sx==dx && sy==dy)
		{
			return true;
		}
		else if(sx>dx || sy>dy)
		{
			return false;
		}
		else
		{
			System.out.println(sx+" "+sy+" "+dx+" "+dy);
			return (isPossible(sx+sy, sy, dx, dy) || isPossible(sx, sy+sx, dx, dy));
		}
   }
	public static void main(String[] args) {
		if(isPossible(1, 2,3, 4))
			{
			System.out.println("yes");
			};
	}
}
