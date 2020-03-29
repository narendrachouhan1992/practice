package GraphAlgos;

public class CheckIfCyclicDirected extends Graph{

	public CheckIfCyclicDirected(int numberOfVertex) {
		super(numberOfVertex);
		// TODO Auto-generated constructor stub
	}
	private boolean detectCycleUntil(int s, boolean[] visited, boolean[] curRec)
	{
		if(curRec[s])
		{
			return true;
		}
		if(visited[s])
			return false;
		visited[s] = true;
		curRec[s] = true;
		for (int i : adj[s]) {
			if(detectCycleUntil(i, visited, curRec))
			{
				return true;
			}
		}
		curRec[s] = false;
		return false;
	}
	
	public boolean cycleDetection()
	{
		boolean[] visited = new boolean[V];
		boolean[] curRec = new boolean[V];
		for(int i=0;i<V;i++)
		{
			if(detectCycleUntil(i, visited, curRec))
			{
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		CheckIfCyclicDirected g = new CheckIfCyclicDirected(4);
		g.addEdge(0, 1);
	    g.addEdge(0, 2);
	    g.addEdge(1, 2);
	    g.addEdge(2, 0);
	    g.addEdge(2, 3);
	    g.addEdge(3, 3);
	    if(g.cycleDetection())
        {
        	System.out.println("cycle exist");
        }
        else
        {
        	System.out.println("cycle doesnot exist");
        }
	}
}
