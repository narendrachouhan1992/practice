package GraphAlgos;

import java.util.ArrayList;
import java.util.List;

public class FindMOtherVertex extends Graph{

	public FindMOtherVertex(int numberOfVertex) {
		super(numberOfVertex);
		// TODO Auto-generated constructor stub
	}
	private void dfsUntil(int s, List<Boolean> visited)
	{
		visited.set(s, true);
		for (Integer i : adj[s]) {
			if(!visited.get(i))
				dfsUntil(i, visited);
		}
	}
	int findMothervertex()
	{
		List<Boolean> visited = new ArrayList<Boolean>();
		for(int i=0;i<V;i++)
		{
			visited.add(i, false);
		}
		int lastVisited = 0;
		for(int i=0;i<V;i++)
		{
			if(!visited.get(i))
			{
				dfsUntil(i, visited);
				lastVisited = i;
			}
		}
		
		// check if lastVisited is ctually a mother vertex or not. that can be find oout by reseting all values of adjusency 
		//matrix and again checking dfs from lastVisited. if it reached to all nodes, then it is a mother vertex
		for(int i=0;i<V;i++)
		{
			visited.set(i, false);
		}
		dfsUntil(lastVisited, visited);
		for(int i=0;i<V;i++)
		{
			if(!visited.get(i))
			{
				
				return -1;
			}	
		}
		return lastVisited;
	}
	public static void main(String[] args) {
		FindMOtherVertex g = new FindMOtherVertex(7);
	    g.addEdge(0, 1);
	    g.addEdge(0, 2);
	    g.addEdge(1, 3);
	    g.addEdge(4, 1);
	    g.addEdge(6, 4);
	    g.addEdge(5, 6);
	    g.addEdge(5, 2);
	    g.addEdge(6, 0);
		int m = g.findMothervertex();
        if(m == -1)
        	System.out.println("no mother vertex exist");
        else
        	System.out.println("mother vertex is "+ m);
	}
}
