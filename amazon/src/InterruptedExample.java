
public class InterruptedExample {
public static void main(String[] args) {
	Thread t = new Thread(()-> {
		if(Thread.currentThread().isInterrupted())
		{
			
		}
	});

	t.isInterrupted();
}
}
