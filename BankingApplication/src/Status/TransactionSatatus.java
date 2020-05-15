package Status;

public class TransactionSatatus {
	private String message;
	private Status status;
	public String getMessage() {
		return message;
	}
	public Status getStatus() {
		return status;
	}
	public TransactionSatatus(String message, Status status) {
		super();
		this.message = message;
		this.status = status;
	}
}
