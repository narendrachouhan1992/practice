package graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
	int val;
	List<Node> adj = new ArrayList<Node>();
	public Node(int val) {
		this.val=val;
	}
}
