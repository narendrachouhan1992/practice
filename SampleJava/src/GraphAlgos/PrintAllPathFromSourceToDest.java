package GraphAlgos;

import java.util.ArrayList;import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PrintAllPathFromSourceToDest extends Graph{

	public PrintAllPathFromSourceToDest(int numberOfVertex) {
		super(numberOfVertex);
	}
	private void printUntil(List<Integer> path, boolean[] visited,int s,int d)
	{
		visited[s] = true;
		if(s== d)
		{
			System.out.println(path.toString());
		}
		for (int i : adj[s]) {
			if(!visited[i])
			{
				path.add(i);
				printUntil(path, visited, i, d);
				path.remove((Object)i);
			}
		}
		visited[s] = false;
	}
	void printAll(int s, int d)
	{
		List<Integer> path = new ArrayList<Integer>();
		boolean[] visited = new boolean[V];
		path.add(s);
		printUntil(path, visited, s, d);
	}
	public static void main(String[] args) {
		PrintAllPathFromSourceToDest g = new PrintAllPathFromSourceToDest(4);
		g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(2,0);
        g.addEdge(2,1);
        g.addEdge(1,3);
        int s = 2;
        // arbitrary destination
        int d = 3;
        
        System.out.println("Following are all different paths from "+s+" to "+d);
        g.printAll(s, d);
	}
}
