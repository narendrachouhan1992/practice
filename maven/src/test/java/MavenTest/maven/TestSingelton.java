package MavenTest.maven;


import static org.powermock.api.easymock.PowerMock.createMock;
import static org.powermock.api.easymock.PowerMock.mockStatic;
import static org.powermock.api.easymock.PowerMock.replay;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class TestSingelton {
	     
	
	
	@Test
	public void testgetuserFilterservice(){
		PowerMockito.suppress(PowerMockito.constructor(Singleton.class));

        mockStatic(Singleton.class);
        Singleton mockSingleton = createMock(Singleton.class);
        EasyMock.expect(mockSingleton.getHostName()).andReturn("myhostName");
        replay(Singleton.class);
        replay(mockSingleton);
        
		try {
			ClassUsingSingelton classUsingSingleton = new ClassUsingSingelton();
			System.out.print(classUsingSingleton.getHostName());
		} catch (Exception e) {
			Assert.fail("Unexpected Exception");
			e.printStackTrace();
		}
	}
}
