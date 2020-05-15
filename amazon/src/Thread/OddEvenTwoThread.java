package Thread;

class Printer {
	volatile boolean isEven;

	synchronized public void porintEven(int num) throws InterruptedException {
		while (!isEven) {
			wait();
		}
		System.out.println(Thread.currentThread().getName()+" "+num);
		isEven = false;
		notify();
	}

	synchronized public void porintOdd(int num) throws InterruptedException {
		while (isEven) {
			wait();
		}
		System.out.println(Thread.currentThread().getName()+" "+num);
		isEven = true;
		notify();
	}
}

class OddEvenPrinter implements Runnable {
	private int max;
	private Printer printer;
	private boolean isOdd;

	public OddEvenPrinter(int max, Printer printer, boolean isOdd) {
		super();
		this.max = max;
		this.printer = printer;
		this.isOdd = isOdd;
		
	}

	@Override
	public void run() {
		int num = isOdd ? 1 : 2;
		while (num <= max) {
			try {
				if (isOdd)
					printer.porintOdd(num);
				else
					printer.porintEven(num);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			num += 2;
		}
	}
}

public class OddEvenTwoThread
{
	public static void main(String[] args) {
		Printer p = new Printer();
		Thread odd = new Thread(new OddEvenPrinter(10, p, true), "Odd Thread");
		Thread even = new Thread(new OddEvenPrinter(10, p, false), "Even Thread");
		odd.start();
		even.start();
	}
}
