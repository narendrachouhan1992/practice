package Exceptions;

public class BankingException extends Exception{
	public BankingException(String e) {
		super("Banking exception:"+e);
	}

}
