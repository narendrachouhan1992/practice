package Exceptions;

public class NoBranchExistException extends BankingException {
	public NoBranchExistException(String e) {
		
		super("No Branch exist with ID exception:"+e);
	}
}
