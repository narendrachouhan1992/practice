package thread;

class CreateThreadRunnable implements Runnable
{

	@Override
	public void run() {
		for(int i=0;i<10;i++)
		{
			System.out.println("thread "+Thread.currentThread().getName() +" is running "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("interrupted");
			}
		}
	}
	public static void main(String[] args) {
		CreateThreadRunnable m1 = new CreateThreadRunnable();
		Thread t1 = new Thread(m1);
		t1.setName("thread 1");
		Thread t2 = new Thread(m1);
		t2.setName("thread 2");
		Thread t3 = new Thread(m1);
		t3.setName("thread 3");
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		t3.start();
	}
}

