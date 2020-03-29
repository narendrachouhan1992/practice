package GraphAlgos;

import java.util.Arrays;
import java.util.LinkedList;

public class TransitiveClosure extends Graph{

	boolean[][] tc; 
	public TransitiveClosure(int numberOfVertex) {
		super(numberOfVertex);
		this.tc = new boolean[numberOfVertex][numberOfVertex];
	}
	private void dfsUntil(int s, int d)
	{
		tc[s][d] = true;
		for (Integer node : adj[d]) {
			if(!tc[s][node])
				dfsUntil(s, node);
		}
	}
	void getTransitiveClosure()
	{
		for(int i=0;i<V;i++)
		{
			dfsUntil(i, i);
		}
		for (int i = 0; i < V; i++) {
          System.out.println(Arrays.toString(tc[i]));
        }
	}
	public static void main(String[] args) {
		TransitiveClosure g = new TransitiveClosure(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Transitive closure " +
                "matrix is");
 
        g.getTransitiveClosure();
	}
}
