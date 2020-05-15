package Exceptions;

public class NoBankAccountExistException extends BankingException {
	public NoBankAccountExistException(String e) {
		
		super("No Account exist with accountID exception:"+e);
	}
}
