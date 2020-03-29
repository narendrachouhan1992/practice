package GraphAlgos;

import java.util.Stack;

public class TopologicalSort extends Graph {

	public TopologicalSort(int numberOfVertex) {
		super(numberOfVertex);
		// TODO Auto-generated constructor stub
	}
	private void topologicalSortUntil(int i, boolean[] visited, Stack<Integer> st)
	{
		visited[i] = true;
		for (Integer node : adj[i]) {
			if(!visited[node])
			{
				topologicalSortUntil(node, visited, st);
			}
		}
		st.push(i);
	}
	void printTopologicalSort()
	{
		boolean[] visited = new boolean[V];
		Stack<Integer> st = new Stack<Integer>();
		for(int i =0;i<V;i++)
		{
			if(!visited[i])
			{
				topologicalSortUntil(i, visited, st);
			}
		}
		while(!st.isEmpty())
		{
			System.out.print(st.pop()+" ");
		}
	}
	public static void main(String[] args) {
		TopologicalSort g = new TopologicalSort(6);
		 g.addEdge(5, 2);
	        g.addEdge(5, 0);
	        g.addEdge(4, 0);
	        g.addEdge(4, 1);
	        g.addEdge(2, 3);
	        g.addEdge(3, 1);
	        System.out.println("Following is a Topological " + "sort of the given graph");
	        g.printTopologicalSort();
	}
}
