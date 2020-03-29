package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphAlgos {
	Node graph;
	int N;
	void isHamiltonian()
	{
		List<Node> path = new ArrayList<Node>();
		path.add(graph);
		if(!isHamiltonianUntil(path, 1))
		{
			System.out.println("hamiltonian cycle doesn't exist");
		}
	}
	private boolean isHamiltonianUntil(List<Node> path, int size)
	{
		Node curr = path.get(size-1);
		if(size==N)
		{
			if(curr.adj.contains(graph))
			{
				path.add(graph);
				System.out.println("Hamiltonian cycle exist");
				path.forEach(s->System.out.print(s.val+" "));
				return true;
			}
			return false;
		}
		for (Node n : curr.adj) {
			if(!path.contains(n))
			{
				path.add(n);
				if(isHamiltonianUntil(path, size+1))
				{
					return true;
				}
				path.remove(size);
			}
		}
		return false;
	}
	Node createGraph2()
	{
		/* Let us create the following graph 
        (0)--(1)--(2) 
         |   / \   | 
         |  /   \  | 
         | /     \ | 
        (3)       (4)  */
		
		Node o0 = new Node(0);
		Node o1 = new Node(1);
		Node o2 = new Node(2);
		Node o3 = new Node(3);
		Node o4 = new Node(4);
		o0.adj.add(o1);
		o0.adj.add(o3);
		o1.adj.add(o2);
		o1.adj.add(o3);
		o1.adj.add(o4);
		o1.adj.add(o0);
		o2.adj.add(o4);
		o2.adj.add(o1);
		o4.adj.add(o2);
		o4.adj.add(o1);
		o3.adj.add(o1);
		o3.adj.add(o0);
		return o0;

	}
	Node createGrapth1()
	{
//		(0)--(1)--(2) 
//      |   / \   | 
//      |  /   \  | 
//      | /     \ | 
//     (3)-------(4)   
		Node o0 = new Node(0);
		Node o1 = new Node(1);
		Node o2 = new Node(2);
		Node o3 = new Node(3);
		Node o4 = new Node(4);
		o0.adj.add(o1);
		o0.adj.add(o3);
		o1.adj.add(o2);
		o1.adj.add(o3);
		o1.adj.add(o4);
		o1.adj.add(o0);
		o2.adj.add(o4);
		o2.adj.add(o1);
		o4.adj.add(o2);
		o4.adj.add(o1);
		o4.adj.add(o3);
		o3.adj.add(o4);
		o3.adj.add(o1);
		o3.adj.add(o0);
		return o0;
	}
	public static void main(String[] args) {
		GraphAlgos obj = new GraphAlgos();
		obj.graph=obj.createGrapth1();
		obj.N = 5;
		obj.isHamiltonian();
		
		System.out.println();
		obj.graph = obj.createGraph2();
		obj.N = 5;
		obj.isHamiltonian();
	}
}
