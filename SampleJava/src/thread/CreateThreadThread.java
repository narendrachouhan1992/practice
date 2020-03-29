package thread;

public class CreateThreadThread  extends Thread {
	public void run()
	{
		System.out.println("thread running"+  this.getName());
	}
	public static void main(String[] args) {
		CreateThreadThread t1 = new CreateThreadThread();
		t1.start();
	}
}
