package Exceptions;

public class NoCustomerExistException extends BankingException {
	public NoCustomerExistException(String e) {
		
		super("No customer exist with panNumber exception:"+e);
	}
}
