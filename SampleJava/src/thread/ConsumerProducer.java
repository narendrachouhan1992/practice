package thread;

import java.util.LinkedList;
import java.util.Queue;

public class ConsumerProducer {
	public static void main(String[] args) {
		Queue<Integer> q =  new LinkedList<Integer>();
		Thread p = new Thread(()-> {
			for(int i=0;i<10;i++)
			{
				synchronized (q) {
					if(q.size()==3)
						try {
							Thread.sleep(1000);
							q.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					q.add(i);
					System.out.println("produced: "+i);
					q.notify();
				}
			}
		});
		Thread c = new Thread(()-> {
			for(int i=0;i<10;i++)
			{
				synchronized (q) {
					if(q.size()==0)
						try {
							Thread.sleep(1000);
							q.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					System.out.println("consumed: "+q.remove());
					q.notify();
				}
			}
		});
		p.start();
		c.start();
	}
}
