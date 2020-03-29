package javaPractice;

public class CustomExceptionUse {
	public void use() throws InsufficientAmmountException
	{
		throw new InsufficientAmmountException(50);
		
	}
	public static void main(String[] args) {
		CustomExceptionUse obj = new CustomExceptionUse();
		try {
			
			obj.use();
		} catch (InsufficientAmmountException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
