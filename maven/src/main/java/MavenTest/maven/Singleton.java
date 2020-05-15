package MavenTest.maven;


import java.io.File;

public class Singleton {
	 
	private static Singleton instance;
    private String hostName;
    private String port;
 
    private Singleton(){
        try{
            readProperties("relativePathInProdSystem"+File.separator+"singleton.properties");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
 
    public static Singleton getInstance(){
    	if(instance==null)
    		instance = new Singleton();
        return instance;
    }
 
    private void readProperties(String fileName) throws Exception{
            hostName = "Hostname Test";
            port = "2222";
    }
 
    public String getHostName() {
        return hostName;
    }
 
    public String getPort() {
        return port;
    }
 
 
}
