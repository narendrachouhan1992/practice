import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentHashMapTest {
	
	public static void main(String[] args) throws InterruptedException {
		Map<Integer, AtomicInteger> map = new ConcurrentHashMap<Integer, AtomicInteger>();
		
		Thread t1 = new Thread(()->{
			for(int i=0;i<1000;i++)
			{
				map.computeIfAbsent(i%10, p->new AtomicInteger()).incrementAndGet();
			}
		});
		Thread t2 = new Thread(()->{
			for(int i=0;i<1000;i++)
			{
				
				map.computeIfAbsent(i%10, p->new AtomicInteger()).incrementAndGet();
				
			}
		});
		Thread t3 = new Thread(()->{
			for(int i=0;i<1000;i++)
			{
				map.computeIfAbsent(i%10, p->new AtomicInteger()).incrementAndGet();
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		t1.join();t2.join();t3.join();
		map.forEach((key, val)->{
			System.out.println(key+ "  "+val);
		});
	}
}
