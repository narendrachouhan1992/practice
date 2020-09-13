package GeeksForGeeks;

public class Node {
	public Node(int data) {
		super();
		this.data = data;
	}
	public Node() {
		// TODO Auto-generated constructor stub
	}
	int data;
	Node next;
	@Override
	public String toString() {
		return Integer.toString(data);
	}
}
