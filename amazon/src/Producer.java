import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable
{
	private BlockingQueue<Integer> blockingQueue;
	public void setBlockingQueue(BlockingQueue<Integer> q)
	{
		this.blockingQueue=q;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++)
		{
			try {
				blockingQueue.put(i);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("produver added:"+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}