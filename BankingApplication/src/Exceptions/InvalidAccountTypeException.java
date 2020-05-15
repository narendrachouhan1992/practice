package Exceptions;

public class InvalidAccountTypeException extends BankingException{
	public InvalidAccountTypeException(String e) {
		super("Account type is not valid:"+e);
	}

}
