package Thread;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
public class TestSingelton {
	private Singelton objUnderTest;
	     
	       @Before
	       public void setup() {
	          try {
	               objUnderTest = 
	                   Whitebox.invokeConstructor(Singelton.class);
	           } catch (Exception e) {
	               System.out.print(e.getMessage());
	           }
	       }
	     
	       @Test
	       public void singletonInstance1() {
	           System.out.println("Singleton class instance 1: " 
	               + objUnderTest);
	           objUnderTest.readProperties("Test1");
	       }
	     
	       @Test
	       public void singletonInstance2() {
	           System.out.println("Singleton class instance 2: " 
	               + objUnderTest);
	           objUnderTest.readProperties("Test2");
	      }
}
