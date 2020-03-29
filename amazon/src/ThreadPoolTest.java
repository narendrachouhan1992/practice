import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(5);
		try {
			pool.invokeAll(getCallables());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	static List<Callable<Integer>> getCallables()
	{
		List<Callable<Integer>> list = new ArrayList<Callable<Integer>>();
		for(int i=0;i<100;i++)
		{
			list.add(()->
			{
				Thread.sleep(1000);
				System.out.println(System.currentTimeMillis()%10);
				return 1;
			});
		}
		return list;
	}
}
