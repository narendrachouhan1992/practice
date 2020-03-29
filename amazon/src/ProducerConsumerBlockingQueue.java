import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;



public class ProducerConsumerBlockingQueue {
	public static void main(String[] args) {
		Consumer c = new Consumer();
		BlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(5);
		c.setBlockingQueue(q);
		Producer p = new Producer();
		p.setBlockingQueue(q);
		
		Thread consumer = new Thread(c);
		Thread producer = new Thread(p);
		consumer.start();
		producer.start();
		
	}
}
