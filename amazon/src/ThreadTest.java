import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		Thread a = new Thread(()-> {
			System.out.println("running a");
		});
	
		executor.submit(a);
	}
}
