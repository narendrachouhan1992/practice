package thread;

import java.util.Queue;

public class Consumer implements Runnable {
	Queue q;
	public Consumer(Queue q) {
		this.q=q;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++)
		{
			
		}
	}

}
