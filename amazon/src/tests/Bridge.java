package tests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Graph {
	private int V; // No. of vertices
	Set<Integer> bridge = new HashSet<Integer>();
	// Array of lists for Adjacency List Representation
	private LinkedList<Integer> adj[];
	int time = 0;
	static final int NIL = -1;

	// Constructor
	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w); // Add w to v's list.
		adj[w].add(v); // Add v to w's list
	}

	List<Integer> bridge() {
		// Mark all the vertices as not visited
		boolean visited[] = new boolean[V];
		int disc[] = new int[V];
		int low[] = new int[V];
		int parent[] = new int[V];

		// Initialize parent and visited, and ap(articulation point)
		// arrays
		for (int i = 0; i < V; i++) {
			parent[i] = NIL;
			visited[i] = false;
		}

		// Call the recursive helper function to find Bridges
		// in DFS tree rooted with vertex 'i'
		for (int i = 0; i < V; i++)
			if (visited[i] == false)
				bridgeUtil(i, visited, disc, low, parent);
		return bridge.stream().map(s-> s+1).collect(Collectors.toList());
	}

	void bridgeUtil(int u, boolean visited[], int disc[], int low[], int parent[]) {

		// Mark the current node as visited
		visited[u] = true;

		// Initialize discovery time and low value
		disc[u] = low[u] = ++time;

		// Go through all vertices aadjacent to this
		Iterator<Integer> i = adj[u].iterator();
		while (i.hasNext()) {
			int v = i.next(); // v is current adjacent of u

			// If v is not visited yet, then make it a child
			// of u in DFS tree and recur for it.
			// If v is not visited yet, then recur for it
			if (!visited[v]) {
				parent[v] = u;
				bridgeUtil(v, visited, disc, low, parent);

				// Check if the subtree rooted with v has a
				// connection to one of the ancestors of u
				low[u] = Math.min(low[u], low[v]);

				// If the lowest vertex reachable from subtree
				// under v is below u in DFS tree, then u-v is
				// a bridge
				if (low[v] > disc[u])
				{
					bridge.add(u);
					bridge.add(v);
					System.out.println(u + " " + v);
				}
			}

			// Update low value of u for parent function calls.
			else if (v != parent[u])
				low[u] = Math.min(low[u], disc[v]);
		}
	}
}
public class Bridge
{
	List<Integer> criticalRouters(int numRouters, int numLinks, ArrayList<ArrayList<Integer>> links)
	{
		Graph g3 = new Graph(numRouters);
		
		for(int i=0;i<numLinks;i++)
		{
			g3.addEdge(links.get(i).get(0)-1, links.get(i).get(1)-1);
		}
		return g3.bridge();
	}
}