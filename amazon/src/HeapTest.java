import java.util.PriorityQueue;
import java.util.Queue;

public class HeapTest {
public static void main(String[] args) {
	Queue<Data> q = new PriorityQueue<Data>();
	q.add(new Data(5));
	q.add(new Data(0));
	q.add(new Data(3));
	q.add(new Data(5));
	q.add(new Data(10));
	q.add(new Data(-1));
	System.out.println(q.toString());
	q.peek().setNum(Integer.MAX_VALUE);
	System.out.println(q.toString());
	q.add(new Data(100));
	System.out.println(q.toString());
}
}
