package newDynamic;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumStepsReachTargetKnight {
	static class Location
	{
		int x; int y;
		int dist = 0;
		public Location(int x, int y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
		}
	}
	boolean isInside(Location curr, int size)
	{
		if(curr.x>=0 && curr.y>= 0 && curr.x<size && curr.y<size)
		{
			return true;
		}
		return false;
	}
	int getMinSteps(Location src, Location dest, int size)
	{
		int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
	    int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};
	 
	    Queue<Location> q = new LinkedList<Location>();
	    boolean[][] visited = new boolean[size][size];
	    q.add(src);
	    while(!q.isEmpty())
	    {
	    	Location q1 = q.poll();
	    	for(int i=0;i<8;i++)
	    	{
	    		if(q1.x == dest.x && q1.y == dest.y)
	    		{
	    			return q1.dist;
	    		}
	    		Location curr = new Location(q1.x+dx[i], q1.y+dy[i]);
	    		if(isInside(curr, size) && !visited[curr.x][curr.y])
	    		{
	    			visited[curr.x][curr.y] = true;
	    			curr.dist = q1.dist+1;
	    			q.add(curr);
	    		}
	    	}
	    }
		return -1;
	}
	public static void main(String[] args) {
		MinimumStepsReachTargetKnight obj = new MinimumStepsReachTargetKnight();
		Location src = new Location(0, 0);
		Location dest = new Location(29, 29);
		System.out.println(obj.getMinSteps(src, dest, 30));
	}
}
