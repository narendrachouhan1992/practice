import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerCode {
	public static void main(String[] args) {
		List<String> queue = new ArrayList(); 
		Thread p = new Thread(new Producers(queue));
		Thread c = new Thread(new Consumers(queue, (s)->System.out.println("Inside callback"+s)));
		p.start();
		c.start();
	}
}

class Producers implements Runnable
{
	List queue;
	public Producers(List<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		synchronized(queue)
		{
			for(int i=0;i<10;i++)
			{
				while(queue.size()>=5)
				{	
					try {
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				queue.add("Number:"+i);
				
				System.out.println("Producer Produced :"+i);
				queue.notify();
			}
		}
	}
	
}

class Consumers implements Runnable
{
	List<String> queue;
	VoidFunction function;
	public Consumers(List<String> queue, VoidFunction function) {
		this.function = function;
		this.queue = queue;
	}
	
	@Override
	public void run() {
		synchronized(queue)
		{
			for(int i=0;i<10;i++)
			{
				while(queue.size()==0)
				{	
					try {
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				function.callBackMethod("Consumer consumed:"+queue.remove(queue.size()-1));
				queue.notify();
			}
		}
		
	}
	
}

interface VoidFunction
{
	void callBackMethod(String in);
}