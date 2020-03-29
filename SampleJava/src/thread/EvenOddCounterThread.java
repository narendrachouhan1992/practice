package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class EvenOddCounterThread {
	public static void main(String[] args) {
		AtomicInteger ae = new AtomicInteger(0);
		Thread even = new Thread(()-> {
			synchronized (ae) {
				for(int i=0;i<10;i++)
				{
					try {
						ae.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(i*2+2);
					ae.notify();
				}
			}
		});
		Thread odd = new Thread(()-> {
			synchronized (ae) {
				for(int i=0;i<10;i++)
				{
					System.out.println(i*2+1);
					ae.notify();
					try {
						ae.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
		even.start();
		odd.start();
		
	}
}
