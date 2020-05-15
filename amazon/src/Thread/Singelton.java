package Thread;

public class Singelton {
	 
    private static final Singelton instance = new Singelton();
 
    private Singelton(){

    }
 
    public static Singelton getInstance(){
        return instance;
    }
 
    public void readProperties(String fileName) {
        System.out.println("Read File : "+ fileName);
    }
 
 
}
