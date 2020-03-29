package Design;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CompletableFutureTest {
	int num=0;
	int getNum()
	{
		return num++;
	}
	double findSquare(int n)
	{
		return n*n;
	}
	double findnext(double n)
	{
		return n+1;
	}
	void printNum(double d)
	{
		System.out.println("digit : "+d);
	}
	public static void main(String[] args) {
		ExecutorService service = new ThreadPoolExecutor(10, 20, 60,TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100));
		CompletableFutureTest obj = new CompletableFutureTest();
		CompletableFuture.supplyAsync(obj::getNum).
		thenApply(obj::findSquare).
		thenApply(obj::findnext).thenAccept(obj::printNum);
		
}
}
