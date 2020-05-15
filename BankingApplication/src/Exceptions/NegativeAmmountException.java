package Exceptions;

public class NegativeAmmountException extends BankingException {
	public NegativeAmmountException(String e) {
		super("Ammount is not correct:"+e);
	}
}
