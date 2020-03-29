package GraphAlgos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	protected int V;
	protected LinkedList<Integer>[] adj;
	public Graph(int numberOfVertex) {
		this.V = numberOfVertex;
		adj = new LinkedList[numberOfVertex];
		for(int i =0;i<numberOfVertex;i++)
		{
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdge(int v,int w)
    {
        adj[v].add(w);
    }
	void printDFS(int source)
	{
		boolean[] visited = new boolean[V];
		Stack<Integer> st = new Stack<Integer>();
		st.push(source);
		while(!st.isEmpty())
		{
			int s = st.pop();
			if(!visited[s])
			{
				System.out.print(s+" ");
				visited[s] = true;
				for (Integer i : adj[s]) {
					if(!visited[i])
					{
						st.push(i);
					}
				}
			}
		}
	}
	void printBFS(int source)
	{
		boolean[] visited = new boolean[V];
		Queue<Integer> q = new LinkedList<Integer>();
	    q.add(source);
        while(!q.isEmpty())
        {
        	int s = q.poll();
        	if(!visited[s])
        	{
        		System.out.print(s+ " ");
        		visited[s] = true;
        		for (Integer n : adj[s]) {
        			if (!visited[n])
                    {
                        q.add(n);
                    }
				}
        	}
        }
	}
	
	
	public static void main(String[] args) {
		Graph g = new Graph(7); 
		 g.addEdge(0, 1);
	    g.addEdge(0, 2);
	    g.addEdge(1, 3);
	    g.addEdge(4, 1);
	    g.addEdge(6, 4);
	    g.addEdge(5, 6);
	    g.addEdge(5, 2);
	    g.addEdge(6, 0);
        System.out.println("BFS from 6 is below");
        g.printBFS(6);
        System.out.println();
        System.out.println("DFS from 6 is below");
        g.printDFS(6);
       
	}
}
