package MavenTest.maven;


public class ClassUsingSingelton {
	public String getHostName() {
		return Singleton.getInstance().getHostName();
	}
}
