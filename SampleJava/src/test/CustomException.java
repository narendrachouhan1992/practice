package test;

public class CustomException extends Exception {
	public static void main(String[] args) throws CustomException {
		throw new CustomException();
	}
}

