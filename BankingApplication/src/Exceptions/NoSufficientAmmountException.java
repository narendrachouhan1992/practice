package Exceptions;

public class NoSufficientAmmountException extends BankingException {
	public NoSufficientAmmountException(String e) {
		super("Transaction not successful:"+e);
	}
}
