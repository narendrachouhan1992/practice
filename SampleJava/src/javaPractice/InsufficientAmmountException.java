package javaPractice;


public class InsufficientAmmountException extends Exception
{	
	private static final long serialVersionUID = 1L;
	private int ammount;
	
	public InsufficientAmmountException(int ammount) {
		this.ammount = ammount;
	}
	private int getAmmount() {
		// TODO Auto-generated method stub
		return this.ammount;
	}
	
}
