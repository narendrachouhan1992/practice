package GeeksForGeeks;

public class Node {
	public Node(int data) {
		super();
		this.data = data;
	}
	int data;
	Node next;
	@Override
	public String toString() {
		return Integer.toString(data);
	}
}
