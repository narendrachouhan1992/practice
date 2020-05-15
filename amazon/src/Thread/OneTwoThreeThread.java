package Thread;

class NumberPrinter {
	volatile int remNum=1;

	synchronized public void printOne(int num) throws InterruptedException {
		while (remNum!= 1) {
			wait();
		}
		System.out.println(Thread.currentThread().getName()+" "+num);
		remNum=2;
		notifyAll();
	}

	synchronized public void printTwo(int num) throws InterruptedException {
		while (remNum!= 2) {
			wait();
		}
		System.out.println(Thread.currentThread().getName()+" "+num);
		remNum=3;
		notifyAll();
	}
	synchronized public void printTree(int num) throws InterruptedException {
		while (remNum!= 3) {
			wait();
		}
		System.out.println(Thread.currentThread().getName()+" "+num);
		remNum=1;
		notifyAll();
	}
}

class OneTwoThreePrinter implements Runnable {
	private int max;
	private NumberPrinter printer;
	private int rem;

	public OneTwoThreePrinter(int max, NumberPrinter printer, int rem) {
		super();
		this.max = max;
		this.printer = printer;
		this.rem = rem;	
	}

	@Override
	public void run() {
		int num = rem;
		while (num <= max) {
			try {
				if (rem==1)
					printer.printOne(num);
				else if(rem==2)
					printer.printTwo(num);
				else
					printer.printTree(num);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			num += 3;
		}
	}
}

public class OneTwoThreeThread
{
	public static void main(String[] args) {
		NumberPrinter p = new NumberPrinter();
		Thread one = new Thread(new OneTwoThreePrinter(10, p, 1), "one Thread");
		Thread two = new Thread(new OneTwoThreePrinter(10, p, 2), "two Thread");
		Thread three = new Thread(new OneTwoThreePrinter(10, p, 3), "three Thread");
		one.start();
		two.start();
		three.start();
	}
}
