package newDynamic.threadPool;

class Tasks implements Runnable {
	String name;

	public Tasks(String name) {
		this.name = name;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		System.out.println("task " + name + " is started");
		for (int i = 0; i < 5; i++) {
			System.out.println(name + " is running step " + i + 1);
			try {
				wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("task " + name + " is finished");
	}
}

class Threads implements Runnable {
	BlockingQueue<Runnable> q;

	public Threads(BlockingQueue<Runnable> q) {
		super();
		this.q = q;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(Thread.currentThread().getName() + " is running");
			Runnable task;
			try {
				task = q.dequeue();
				task.run();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}

class ThreadPool {
	BlockingQueue<Runnable> queue = new BlockingQueue<>(3);

	public ThreadPool(int queueSize, int nThread) {
		queue = new BlockingQueue<>(queueSize);
		String threadName = null;
		Threads task = null;
		for (int count = 0; count < nThread; count++) {
			threadName = "Thread-" + count;
			task = new Threads(queue);
			Thread thread = new Thread(task, threadName);
			thread.start();
		}
	}

	public void submitTask(Runnable task) throws InterruptedException {
		queue.enqueue(task);
	}
}
class ThreadPoolImplementation
{
	public static void main(String[] args) {
		ThreadPool threadPool = new ThreadPool(3,4);
        //Created 15 Tasks and submit to pool
        for(int taskNumber = 1 ; taskNumber <= 7; taskNumber++) {
            Tasks task = new Tasks(Integer.toString(taskNumber));          
            try {
				threadPool.submitTask(task);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
}