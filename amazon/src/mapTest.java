import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class mapTest {
public static void main(String[] args)
{
	Map<Integer, AtomicInteger> map = new ConcurrentHashMap<Integer, AtomicInteger>();
	System.out.println(map.computeIfAbsent(1, p-> new AtomicInteger()).incrementAndGet());
	
	
}
}
